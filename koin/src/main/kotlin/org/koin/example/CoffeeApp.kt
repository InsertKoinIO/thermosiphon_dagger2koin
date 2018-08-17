package org.koin.example

import org.koin.core.time.Duration
import org.koin.log.EmptyLogger
import org.koin.log.PrintLogger
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject

class CoffeeApp : KoinComponent, Runnable {

    val coffeeMaker: CoffeeMaker by inject()

    override fun run() {
        coffeeMaker.brew()
    }
}

fun main(vararg args: String) {
    val duration = Duration()
    duration.start()

    startKoin(listOf(coffeeMakerModule), logger = PrintLogger(showDebug = true))
    CoffeeApp().run()

    duration.stop()

    println("executed in ${duration.durationInMs()} ms")
}
