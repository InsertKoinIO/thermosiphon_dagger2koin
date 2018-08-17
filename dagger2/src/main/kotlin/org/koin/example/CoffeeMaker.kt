package org.koin.example

import dagger.Lazy
import javax.inject.Inject


class CoffeeMaker @Inject constructor(val pump: Pump, val heater: Lazy<Heater>) {

    fun brew() {
        heater.get().on()
        pump.pump()
        println(" [_]P coffee! [_]P ")
        heater.get().off()
    }
}