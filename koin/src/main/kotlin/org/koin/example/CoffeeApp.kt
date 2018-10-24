package org.koin.example

import org.koin.log.EmptyLogger
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import kotlin.system.measureTimeMillis

class CoffeeApp : KoinComponent {

    val maker: CoffeeMaker by inject()
}


fun main(vararg args: String) {

    startKoin(
        list = listOf(coffeeAppModule),
        logger = EmptyLogger()
    )
    val coffeeApp = CoffeeApp()

    val appDuration = measureTimeMillis {
        coffeeApp.maker.brew()
    }

    println("executed in $appDuration ms")
}
