package org.koin.example


class CoffeeMaker(private val pump: Pump, private val _heater: Lazy<Heater>) {

    val heater: Heater by lazy { _heater.value }

    fun brew() {
        heater.on()
        pump.pump()
        println(" [_]P coffee! [_]P ")
        heater.off()
    }
}