package org.koin.example

//class CoffeeMakerTest : KoinTest {
//
//    val heater: Heater by inject()
//    val coffeeMaker: CoffeeMaker by inject()
//
//    @Before
//    fun before() {
//        startKoin(listOf(coffeeMakerModule))
//        declareMock<Heater>()
//    }
//
//    @After
//    fun after() {
//        stopKoin()
//    }
//
//    @Test
//    fun testHeaterIsTurnedOnAndThenOff() {
//        given(heater.isHot()).will { true }
//        coffeeMaker.brew()
//        Mockito.verify(heater, times(1)).on()
//        Mockito.verify(heater, times(1)).off()
//    }
//}