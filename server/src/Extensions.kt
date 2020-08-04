package com.weathershift

import com.weathershift.db.table.Cities
import org.jetbrains.exposed.sql.ResultRow
import ru.civilea.common.models.City

fun ResultRow.toCity() = City(
    id = this[Cities.id],
    name = this[Cities.name],
    weatherDegree = this[Cities.weatherDegree]
)