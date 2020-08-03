package ru.civilea.city_list.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.civilea.city_list.CityViewModel

val cityModule = module {
    viewModel { CityViewModel(get(named("networkRepo"))) }
}
