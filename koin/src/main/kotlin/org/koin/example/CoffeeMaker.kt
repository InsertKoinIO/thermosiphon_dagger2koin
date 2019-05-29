package org.koin.example


class CoffeeMaker(private val pump: Pump, _heater: Lazy<Heater>) {

    val heater by _heater

    // Don't want to create a possibly costly _heater until we need it.
    fun brew() {
        heater.on()
        pump.pump()
        println(" [_]P coffee! [_]P ")
        heater.off()
    }
}