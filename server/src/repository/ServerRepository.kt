package com.weathershift.repository

import com.weathershift.db.dbQuery
import com.weathershift.db.table.Cities
import com.weathershift.toCities
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement
import org.jetbrains.exposed.sql.update
import ru.civilea.common.Repository
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto

class ServerRepository : Repository<City, CreateCityDto> {
    override suspend fun getAll() =
        dbQuery {
            Cities.selectAll().map { it.toCities() }
        }

    override suspend fun add(elem: CreateCityDto) {
        dbQuery {
            Cities.insert { insertStatement: InsertStatement<Number> ->
                insertStatement[name] = elem.name
                insertStatement[weatherDegree] = elem.weatherDegree
            }
        }
    }

    override suspend fun deleteById(id: Long) {
        dbQuery {
            Cities.deleteWhere {
                Cities.id.eq(id)
            }
        }
    }

    override suspend fun updateElem(elem: City): Int {
        var counter = 0
        dbQuery {
            Cities.update({ Cities.id eq elem.id }) { updateStatement: UpdateStatement ->
                updateStatement[name] = elem.name
                updateStatement[weatherDegree] = elem.weatherDegree
                counter++
            }
        }
        return counter
    }
}

