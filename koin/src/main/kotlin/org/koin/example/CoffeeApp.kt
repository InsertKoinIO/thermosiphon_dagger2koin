package org.koin.example

import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject
import kotlin.system.measureTimeMillis

class CoffeeApp : KoinComponent {

    val maker: CoffeeMaker by inject()
}

fun main() {

    startKoin {
        logger()
        modules(coffeeAppModule)
    }

    val appDuration = measureTimeMillis {
        CoffeeApp().maker.brew()
    }

    println("executed in $appDuration ms")
}
