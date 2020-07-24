package ru.civilea.weathershift.model

data class City(
    var id:Long=0,
    var name:String="",
    var weather:Weather=Weather()
)