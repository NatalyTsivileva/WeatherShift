package ru.civilea.weathershift.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_weather_detail.view.*
import kotlinx.android.synthetic.main.item_weather.view.*
import kotlinx.android.synthetic.main.item_weather.view.cityIV
import ru.civilea.weathershift.R

class WeatherDetailFragment : Fragment() {
    private val args by navArgs<WeatherDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            view.detailsCityIV.background=args.city.weather.getWeatherImage(it)
            view.detailsCityNameTV.text = args.city.name
            view.detailsWeatherNameTV.text = args.city.weather.getWeatherType(it)
        }
    }
}