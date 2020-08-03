package ru.civilea.network.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.civilea.common.Repository
import ru.civilea.network.CityApi
import ru.civilea.network.CityRepository

val baseUrl="https://shiftweather.herokuapp.com/"
val networkModule=module{
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    single(named("networkRepo")) {
        CityRepository(retrofit.create(CityApi::class.java))
    } bind Repository::class
}