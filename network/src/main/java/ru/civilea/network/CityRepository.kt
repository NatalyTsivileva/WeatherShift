package ru.civilea.network

import ru.civilea.common.Repository
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto

class CityRepository(
    private val api: CityApi
) : Repository<City, CreateCityDto> {

    override suspend fun getAll() = api.getAll()

    override suspend fun add(elem: CreateCityDto) {
        api.add(elem)
    }

    override suspend fun deleteById(id: Long) {
        api.deleteById(id)
    }

    override suspend fun updateElem(elem: City): Int {
        return api.updateElem(elem)
    }

}