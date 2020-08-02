package com.weathershift.db.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Cities : Table(){
    var id: Column<Long> = Cities.long("city_id").autoIncrement().primaryKey()
    var name: Column<String> = Cities.text("name")
    var weatherDegree: Column<Long> = Cities.long("weather_degree")
}