package org.koin.example

import org.koin.dsl.module.module

val coffeeAppModule = module {

    single<Heater> { ElectricHeater() }
}