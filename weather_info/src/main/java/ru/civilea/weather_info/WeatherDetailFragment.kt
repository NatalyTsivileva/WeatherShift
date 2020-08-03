package ru.civilea.weather_info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_weather_detail.view.*
import ru.civilea.common.models.City
import ru.civilea.core.model.getWeatherType


class WeatherDetailFragment : Fragment(R.layout.fragment_weather_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val city: City = arguments?.get("city") as City
            context?.let {
                view.detailsCityNameTV.text = city.name
                view.detailsWeatherNameTV.text = city.getWeatherType(it)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}