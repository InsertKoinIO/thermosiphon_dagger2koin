package org.koin.example

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import javax.inject.Inject


class CoffeeMaker @Inject constructor(private val pump: Pump) : KoinComponent {

    val heater: Heater by inject()
//    val heater: Heater by lazy { _heater.get() }

    fun brew() {
        heater.on()
        pump.pump()
        println(" [_]P coffee! [_]P ")
        heater.off()
    }
}