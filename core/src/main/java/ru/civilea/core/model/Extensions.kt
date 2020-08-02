package ru.civilea.core.model

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ru.civilea.common.Weather
import ru.civilea.core.R

fun Fragment.getMainNavController()=
    activity?.findNavController(R.id.main_nav_host_fragment)

fun Weather.getWeatherType(context: Context)= when (degree) {
    in coldWeather.interval -> context.resources.getString(R.string.coldWeather)
    in warmWeather.interval -> context.resources.getString(R.string.warmWeather)
    in hotWeather.interval -> context.resources.getString(R.string.hotWeather)
    else -> context.resources.getString(R.string.catastrophicWeather)
}

fun Weather.getWeatherImage(context: Context)= when (degree) {
    in coldWeather.interval -> context.resources.getDrawable(R.drawable.cold_picture,null)
    in warmWeather.interval -> context.resources.getDrawable(R.drawable.warm_picture,null)
    in hotWeather.interval -> context.resources.getDrawable(R.drawable.hot_picture,null)
    else -> context.resources.getDrawable(R.drawable.catastrophic_picture,null)
}