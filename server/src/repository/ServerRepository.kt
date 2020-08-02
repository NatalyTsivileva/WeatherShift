package com.weathershift.repository

import com.weathershift.db.dbQuery
import com.weathershift.db.table.Cities
import com.weathershift.db.table.Weathers
import com.weathershift.toCities
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement
import ru.civilea.common.Repository
import ru.civilea.common.models.City
import ru.civilea.common.models.CityAndWeatherDto
import ru.civilea.common.models.CreateCityDto
import ru.civilea.common.models.Weather

class ServerRepository : Repository<City, CityAndWeatherDto,City> {
    override suspend fun getAll() =
        dbQuery {
            Cities.selectAll().map { it.toCities() }
        }

    override suspend fun add(data:CityAndWeatherDto) {
        dbQuery {
           val weather= Weathers.insert {insertStatement: InsertStatement<Number> ->
               insertStatement[degree] = data.weatherDto.degree
            }
            Cities.insert { insertStatement: InsertStatement<Number> ->
                insertStatement[name] = data.cityDto.name
                insertStatement[weatherId] = weather[id]
            }
        }
    }

    override suspend fun deleteParent(parent: City) {
        dbQuery {
            Cities.deleteWhere{
                Cities.id.eq(parent.id)
            }
        }
    }
}

