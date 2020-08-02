package ru.civilea.network

import ru.civilea.common.models.City
import ru.civilea.common.CityFactory
import ru.civilea.common.Repository
import ru.civilea.common.models.CreateCityDto

class CityRepositoryImpl: Repository<City,CreateCityDto,City> {
    //todo : not load
    override suspend fun getAll(): List<City> {
        return CityFactory.getRandomCityList(size = 20)
    }

    override suspend fun deleteParent(parent: City) {
        //TODO("Not yet implemented")
    }

    override suspend fun add(elem: CreateCityDto) {
        //TODO("Not yet implemented")
    }
}