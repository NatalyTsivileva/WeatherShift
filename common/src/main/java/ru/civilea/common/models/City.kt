package ru.civilea.common.models

import java.io.Serializable

data class City(
    val id: Long = 0,
    val name: String = "",
    val weatherDegree: Long = 0
) : Serializable