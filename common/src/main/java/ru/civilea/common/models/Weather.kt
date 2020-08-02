package ru.civilea.common.models
import java.io.Serializable

data class Weather(
    val id:Long=0,
    val degree:Long=0
) : Serializable