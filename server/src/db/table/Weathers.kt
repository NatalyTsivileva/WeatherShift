package com.weathershift.db.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.io.Serializable

object Weathers: Table(){
    var id: Column<Long> = Weathers.long("weather_id").autoIncrement().primaryKey()
    var degree: Column<Long> = Weathers.long("degree")
}