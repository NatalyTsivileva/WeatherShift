package ru.civilea.weathershift

import org.koin.dsl.bind
import org.koin.dsl.module
import ru.civilea.core.model.Navigator
import ru.civilea.weathershift.ru.civilea.weathershift.MainNavigatorImpl

val navigationModule = module {
     single { MainNavigatorImpl() } bind Navigator::class
}
