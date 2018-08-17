package org.koin.example

import javax.inject.Inject

class Thermosiphon @Inject constructor(val heater: Heater) : Pump{
    override fun pump() {
        if (heater.isHot()){
            println("=> => pumping => =>")
        }
    }
}