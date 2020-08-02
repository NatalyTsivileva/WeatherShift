package ru.civilea.common
import java.io.Serializable

data class City(
    var id:Long=0,
    var name:String="",
    var weather:Weather=Weather()
) : Serializable