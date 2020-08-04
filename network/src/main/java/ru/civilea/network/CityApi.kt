package ru.civilea.network

import retrofit2.http.*
import ru.civilea.common.models.City
import ru.civilea.common.models.CreateCityDto

interface CityApi {
    @GET("cities")
    suspend fun getAll(): List<City>

    @GET("cities")
    suspend fun getPage(
        @Query("startId")
        startId:Long,
        @Query("pageSize")
        pageSize:Int=10
    ): List<City>

    @POST("cities")
    suspend fun add(@Body elem: CreateCityDto)

    @DELETE("cities")
    suspend fun deleteById(@Query("id") id: Long)

    @POST("cities/update")
    suspend fun updateElem(@Body elem: City): Int
}

