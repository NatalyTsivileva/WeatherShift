package ru.civilea.network

import ru.civilea.common.City
import ru.civilea.common.CityFactory
import ru.civilea.core.model.Repository

class CityRepositoryImpl:Repository<City> {
    //todo : not load
    override fun getAll(): List<City> {
        return CityFactory.getRandomCityList(size = 20)
    }
}