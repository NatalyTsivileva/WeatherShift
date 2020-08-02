package ru.civilea.common.models
import java.io.Serializable

data class CreateCityDto (
val name:String="",
val weatherId:Long=0
) : Serializable
