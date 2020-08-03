package ru.civilea.network

import retrofit2.http.*
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto

interface CityApi {
    @GET("cities")
    suspend fun getAll(): List<City>

    @POST("cities")
    suspend fun add(@Body elem: CreateCityDto)

    @DELETE
    suspend fun deleteById(@Query("id") id: Long)

    @POST
    suspend fun updateElem(@Body elem: City): Int
}

