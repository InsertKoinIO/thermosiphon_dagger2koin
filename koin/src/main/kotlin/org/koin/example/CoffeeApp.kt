package org.koin.example

import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject

class CoffeeApp : KoinComponent {

    val maker: CoffeeMaker by inject()
}

fun main() {
    measure("startup") {
        startKoin {
            modules(coffeeAppModule)
        }
    }
    measure("execution #1") {
        CoffeeApp().maker.brew()
    }
    measure("execution #2") {
        CoffeeApp().maker.brew()
    }
}

fun measure(msg: String, code: () -> Unit) {
    val start = System.nanoTime()
    code()
    val time = (System.nanoTime() - start) / 1000000.0
    println("$msg - $time ms")
}