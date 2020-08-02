package ru.civilea.common.models

import java.io.Serializable

data class CityAndWeatherDto (
    val cityDto:CreateCityDto,
    val weatherDto: CreateWeatherDto
):Serializable