package org.koin.example

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DripCoffeeModule::class])
interface CoffeeApp {
    fun maker(): CoffeeMaker
}

fun main() {
    run()
    run()
}

private fun run() {
    lateinit var coffeeShop: CoffeeApp
    measure("startup") {
        coffeeShop = DaggerCoffeeApp
                .builder().build()
    }
    measure("execution") {
        val maker = coffeeShop.maker()
        maker.brew()
    }
    measure("execution") {
        val maker = coffeeShop.maker()
        maker.brew()
    }
}


fun measure(msg: String, code: () -> Unit) {
    val start = System.nanoTime()
    code()
    val time = (System.nanoTime() - start) / 1000000.0
    println("$msg - $time ms")
}
