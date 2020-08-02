package com.weathershift.di

import com.weathershift.repository.ServerRepository
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.civilea.common.Repository

val serverModule=module{
    single(named("serverRepo")){
        ServerRepository()
    }bind Repository::class
}