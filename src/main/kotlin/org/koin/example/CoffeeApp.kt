package org.koin.example

import dagger.Component
import javax.inject.Singleton
import kotlin.system.measureTimeMillis

@Singleton
@Component(modules = [DripCoffeeModule::class])
interface CoffeeApp {
    fun maker(): CoffeeMaker
}

fun main(vararg args: String) {

    val coffeeShop = DaggerCoffeeApp.builder().build()

    val duration = measureTimeMillis {
        coffeeShop.maker().brew()
    }

    println("executed in $duration ms")
}
