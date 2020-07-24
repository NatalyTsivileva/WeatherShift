package ru.civilea.weathershift.repository

import ru.civilea.weathershift.factory.CityFactory
import ru.civilea.weathershift.model.City
import ru.civilea.weathershift.repository.network.Repository

class CityRepositoryImpl :Repository<City>{

   //TODO("Not yet implemented") - don't load, just generate
    override fun download(): List<City> {
        return CityFactory.getRandomCityList(size = 20)
    }

}