package ru.civilea.common
import java.io.Serializable

data class Weather(
    var id:Long=0,
    var degree:Long=0
) : Serializable