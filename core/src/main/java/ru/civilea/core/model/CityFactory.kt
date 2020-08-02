package ru.civilea.core.model

import ru.civilea.weathershift.model.City
import ru.civilea.weathershift.model.Weather
import kotlin.random.Random

class CityFactory {

    companion object {

        fun getRandomCityList(size: Int = 10): List<City> {
            val list = mutableListOf<City>()
            for (i in 0 until size) {
                val city = City(name = "Город ${i}", weather = getRandomWeather())
                list.add(city)
            }
            return list
        }

        fun getRandomWeather() = Weather(degree = Random.nextLong(from = -100, until = 100))
    }
}