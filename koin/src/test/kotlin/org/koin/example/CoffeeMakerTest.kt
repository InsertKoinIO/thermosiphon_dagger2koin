package org.koin.example

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.times

class CoffeeMakerTest : KoinTest {

    val heater: Heater by inject()
    val coffeeMaker: CoffeeMaker by inject()

    @Before
    fun before() {
        startKoin {
            printLogger(Level.DEBUG)
            modules(coffeeAppModule)
        }

        declareMock<Heater> {
            given(isHot()).will { true }
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun testHeaterIsTurnedOnAndThenOff() {

        coffeeMaker.brew()
        Mockito.verify(heater, times(1)).on()
        Mockito.verify(heater, times(1)).off()
    }
}