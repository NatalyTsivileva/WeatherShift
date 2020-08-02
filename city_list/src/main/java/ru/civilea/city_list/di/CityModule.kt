package ru.civilea.city_list.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.civilea.city_list.CityViewModel
import ru.civilea.common.Repository
import ru.civilea.network.CityRepositoryImpl

val cityModule= module{
    single { CityRepositoryImpl()} bind Repository::class
    viewModel { CityViewModel(androidApplication(), get()) }
}
