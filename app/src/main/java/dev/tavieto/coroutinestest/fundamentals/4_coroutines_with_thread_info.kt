package dev.tavieto.coroutinestest.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() {
    return runBlocking {
        println("main starts")
        joinAll(
            async { coroutineWithThreadInfo(1, 500) },
            async { coroutineWithThreadInfo(2, 300) }
        )
        println("main ends")
    }
}

private suspend fun coroutineWithThreadInfo(number: Int, delay: Long) {
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has finished on ${Thread.currentThread().name} ")
}
