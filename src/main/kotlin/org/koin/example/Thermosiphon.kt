package org.koin.example

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import javax.inject.Inject

class Thermosiphon @Inject constructor() : Pump, KoinComponent {

    val heater: Heater by inject()

    override fun pump() {
        if (heater.isHot()) {
            println("=> => pumping => =>")
        }
    }
}