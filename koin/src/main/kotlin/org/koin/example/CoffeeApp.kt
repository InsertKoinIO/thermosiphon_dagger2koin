package org.koin.example

import org.koin.core.Koin
import org.koin.core.time.measureDuration
import org.koin.log.PrintLogger
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.koin.standalone.inject

class CoffeeApp : KoinComponent {

    val coffeeMaker: CoffeeMaker by inject()

    fun brew() {
        coffeeMaker.brew()
    }
}

fun main(vararg args: String) {
    val global = measureDuration {
        val koinStartDuration = measureDuration {
            Koin.logger = PrintLogger(showDebug = true)
            loadKoinModules(coffeeMakerReflectModule)
        }

        println("koin started in $koinStartDuration ms")

        val appDuration = measureDuration {
            CoffeeApp().brew()
        }
        println("App run in $appDuration ms")
    }

    println("executed in $global ms")
}
