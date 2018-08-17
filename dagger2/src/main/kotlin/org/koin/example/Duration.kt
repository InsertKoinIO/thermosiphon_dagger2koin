package org.koin.example

/**
 * Simple class to measure durations
 */
class Duration {

    private var start = 0L
    private var end = 0L

    fun start(){
        start = System.nanoTime()
    }

    fun stop(){
        end = System.nanoTime()
    }

    fun durationInMs() = (end - start) / 1000000
}

/**
 * Help measure a time of executed code
 */
fun measureDuration(codeToRun : () -> Unit): Long {
    val duration = Duration()
    duration.start()
    codeToRun()
    duration.stop()
    return duration.durationInMs()
}