package com.weathershift

import com.weathershift.db.DatabaseFactory
import com.weathershift.repository.ServerRepository
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto
import java.net.URI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
    val dbUri = URI(environment.config.property("db.jdbcUrl").getString())

    val username: String = dbUri.userInfo.split(":")[0]
    val password: String = dbUri.userInfo.split(":")[1]
    val dbUrl = ("jdbc:postgresql://${dbUri.host}:${dbUri.port}${dbUri.path}")

    DatabaseFactory(
        dbUrl = dbUrl,
        dbPassword = password,
        dbUser = username
    ).apply {
        init()
    }

    val repository = ServerRepository()

    routing {
        route("cities") {
            get {
                val list = repository.getAll()
                call.respond(list)
            }

            post {
                val data = call.receive<CreateCityDto>()
                repository.add(data)
                call.respond(HttpStatusCode.OK)
            }

            delete {
                val id = call.request.queryParameters["id"]?.toLong()
                id?.let {
                    repository.deleteById(it)
                    call.respond(HttpStatusCode.OK)
                    return@delete
                }
                call.respond(HttpStatusCode.NotFound)
            }

            post(path = "/update") {
                val data = call.receive<City>()
                val updatedCount = repository.updateElem(data)
                if (updatedCount > 0) {
                    call.respond(updatedCount)
                } else {
                    call.respond(0)
                }
            }
        }
    }
}

