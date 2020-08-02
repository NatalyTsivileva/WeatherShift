package ru.civilea.common.models

import java.io.Serializable

data class City(
    val id: Long = 0,
    val name: String = "",
    val weatherId: Long = 0
) : Serializable {

    fun toCityDto() = CreateCityDto(name = name, weatherId = weatherId)
}