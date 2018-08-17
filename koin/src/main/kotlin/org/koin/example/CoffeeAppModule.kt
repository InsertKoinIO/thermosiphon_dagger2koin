package org.koin.example

import org.koin.dsl.module.module
import org.koin.reflect.single
import org.koin.reflect.singleOf

val coffeeMakerReflectModule = module {
    // With reflect
    single<CoffeeMaker>()
    singleOf<Thermosiphon, Pump>()
    singleOf<ElectricHeater, Heater>()
}

val coffeeMakerModule = module {
    // No reflect
    single { CoffeeMaker(get()) }
    single { Thermosiphon(get()) as Pump }
    single { ElectricHeater() as Heater }
}