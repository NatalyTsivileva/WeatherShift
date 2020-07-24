package ru.civilea.weathershift.model

import android.content.Context
import ru.civilea.weathershift.R

sealed class WeatherType(val interval: IntRange)
object coldWeather : WeatherType(-50 until 15)
object warmWeather : WeatherType(15 until 25)
object hotWeather : WeatherType(25 until 50)

data class Weather(
    var id:Long=0,
    var degree:Long=0
){
    var type:WeatherType?=null

     fun getWeatherType(context:Context)= when (degree) {
         in coldWeather.interval -> context.resources.getString(R.string.coldWeather)
         in warmWeather.interval -> context.resources.getString(R.string.warmWeather)
         in hotWeather.interval -> context.resources.getString(R.string.hotWeather)
         else -> context.resources.getString(R.string.catastrophicWeather)
     }
}