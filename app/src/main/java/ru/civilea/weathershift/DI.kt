package ru.civilea.weathershift

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.civilea.weathershift.repository.CityRepositoryImpl
import ru.civilea.weathershift.repository.network.Repository
import ru.civilea.weathershift.viewModels.CityViewModel

val cityModule=module{
    single { CityRepositoryImpl()} bind Repository::class
    viewModel { CityViewModel(androidApplication(),get()) }
}