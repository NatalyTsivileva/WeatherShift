package ru.civilea.splash.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.civilea.splash.SplashVewModel


val splashModule = module {
    viewModel { SplashVewModel() }
}