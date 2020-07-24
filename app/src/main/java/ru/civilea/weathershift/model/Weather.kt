package ru.civilea.weathershift.model

import android.content.Context
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.civilea.weathershift.R

sealed class WeatherType(val interval: IntRange)
object coldWeather : WeatherType(-50 until 15)
object warmWeather : WeatherType(15 until 25)
object hotWeather : WeatherType(25 until 50)

@Parcelize
data class Weather(
    var id:Long=0,
    var degree:Long=0
) : Parcelable {
     fun getWeatherType(context:Context)= when (degree) {
         in coldWeather.interval -> context.resources.getString(R.string.coldWeather)
         in warmWeather.interval -> context.resources.getString(R.string.warmWeather)
         in hotWeather.interval -> context.resources.getString(R.string.hotWeather)
         else -> context.resources.getString(R.string.catastrophicWeather)
     }

    fun getWeatherImage(context:Context)= when (degree) {
        in coldWeather.interval -> context.resources.getDrawable(R.drawable.cold_picture,null)
        in warmWeather.interval -> context.resources.getDrawable(R.drawable.warm_picture,null)
        in hotWeather.interval -> context.resources.getDrawable(R.drawable.hot_picture,null)
        else -> context.resources.getDrawable(R.drawable.catastrophic_picture,null)
    }
}