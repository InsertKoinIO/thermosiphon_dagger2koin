package org.koin.example

import dagger.Lazy
import javax.inject.Inject


class CoffeeMaker @Inject constructor(private val pump: Pump, private val _heater: Lazy<Heater>) {

    val heater: Heater by lazy { _heater.get() }

    fun brew() {
        heater.on()
        pump.pump()
        println(" [_]P coffee! [_]P ")
        heater.off()
    }
}