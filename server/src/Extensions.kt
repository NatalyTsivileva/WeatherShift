package com.weathershift

import com.weathershift.db.table.Cities
import org.jetbrains.exposed.sql.ResultRow
import ru.civilea.common.models.City

fun ResultRow.toCities() = City(
    id = this[Cities.id],
    name = this[Cities.name],
    weatherDegree = this[Cities.weatherDegree]
)