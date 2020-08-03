package ru.civilea.weathershift.ru.civilea.weathershift.common

import android.app.Application
import com.weathershift.di.serverModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.civilea.city_list.di.cityModule
import ru.civilea.network.di.networkModule
import ru.civilea.splash.di.splashModule
import ru.civilea.weathershift.ru.civilea.weathershift.di.navigationModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                navigationModule,
                splashModule,
                cityModule,
                serverModule,
                networkModule
            )
        }

    }
}