package org.koin.example

import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.inject

class CoffeeApp : KoinComponent {

    val maker: CoffeeMaker by inject()
}

fun main() {
    run()
    run()
}

private fun run() {
    measure("startup") {
        startKoin {
//            printLogger()
            modules(coffeeAppModule)
        }
    }
    measure("execution") {
        val maker = CoffeeApp().maker
        maker.brew()
    }
    measure("execution") {
        val maker = CoffeeApp().maker
        maker.brew()
    }
    stopKoin()
}

fun measure(msg: String, code: () -> Unit) {
    val start = System.nanoTime()
    code()
    val time = (System.nanoTime() - start) / 1000000.0
    println("$msg - $time ms")
}