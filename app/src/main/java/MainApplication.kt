package ru.civilea.weathershift

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.civilea.city_list.di.cityModule
import ru.civilea.splash.di.splashModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(cityModule, splashModule,navigationModule)
        }

    }
}