package ru.civilea.city_list.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.civilea.city_list.CityViewModel
import ru.civilea.city_list.paginator.CityPaginator
import ru.civilea.core.model.pagination.Paginator

val cityModule = module {
    single {
        CityPaginator(repository = get(named("networkRepo")))
    } bind Paginator::class

    viewModel { CityViewModel(paginator = get(), repository = get(named("networkRepo"))) }
}
