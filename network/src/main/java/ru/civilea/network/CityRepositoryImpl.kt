package ru.civilea.network

import ru.civilea.core.model.CityFactory
import ru.civilea.core.model.Repository
import ru.civilea.weathershift.model.City
import ru.civilea.weathershift.model.Weather

class CityRepositoryImpl:Repository<City> {
    //todo : not load
    override fun getAll(): List<City> {
        return CityFactory.getRandomCityList(size = 20)
    }
}