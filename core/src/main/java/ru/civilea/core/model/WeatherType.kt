package ru.civilea.core.model

sealed class WeatherType(val interval: IntRange)
object coldWeather : WeatherType(-50 until 15)
object warmWeather : WeatherType(15 until 25)
object hotWeather : WeatherType(25 until 50)