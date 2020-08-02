package ru.civilea.common.models

import java.io.Serializable

data class CreateWeatherDto(
    val degree: Long = 0
) : Serializable