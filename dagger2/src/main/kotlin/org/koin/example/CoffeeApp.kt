package org.koin.example

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DripCoffeeModule::class])
interface CoffeeApp {
    fun maker(): CoffeeMaker
}

fun main(vararg args: String) {
    val duration = measureDuration {

        val coffeeShop: CoffeeApp = DaggerCoffeeApp.builder().build()
        coffeeShop.maker().brew()
    }

    println("executed in $duration ms")
}
