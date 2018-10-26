package org.koin.example

import dagger.Component
import org.koin.log.PrintLogger
import org.koin.standalone.StandAloneContext.startKoin
import javax.inject.Singleton
import kotlin.system.measureTimeMillis

@Singleton
@Component(modules = [PumpModule::class])
interface CoffeeApp {
    fun maker(): CoffeeMaker
}

fun main(vararg args: String) {

    startKoin(
        list = listOf(coffeeAppModule),
        logger = PrintLogger()
    )

    val coffeeShop = DaggerCoffeeApp.builder().build()

    val duration = measureTimeMillis {
        coffeeShop.maker().brew()
    }

    println("executed in $duration ms")
}
