package com.weathershift

import com.sun.xml.internal.ws.util.InjectionPlan
import com.weathershift.db.DatabaseFactory
import com.weathershift.repository.ServerRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.request.receive
import org.koin.ktor.ext.get
import org.koin.ktor.ext.inject
import ru.civilea.common.models.City
import ru.civilea.common.models.CityAndWeatherDto
import ru.civilea.common.models.Weather
import java.net.URI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
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


    routing {
        val repository:ServerRepository by inject()

        route("/cities") {
            get("/all") {
                val list=repository.getAll()
                call.respond(list)
            }

            post{
              val data=call.receive<CityAndWeatherDto>()
              repository.add(data)
            }

            delete {

            }
        }
    }
}

