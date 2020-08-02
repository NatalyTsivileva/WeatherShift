package ru.civilea.weather_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_weather_detail.view.*
import ru.civilea.common.City
import ru.civilea.core.model.getWeatherType


class WeatherDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val city: City = arguments?.get("city") as City
            context?.let {
                view.detailsCityNameTV.text = city.name
                view.detailsWeatherNameTV.text = city.weather.getWeatherType(it)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}