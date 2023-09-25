package dev.tavieto.coroutinestest.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() {
    return runBlocking {
        println("main starts")
        joinAll(
            async { suspendingCoroutine(1, 500) },
            async { suspendingCoroutine(2, 300) },
            async {
                repeat(5) {
                    println("performing other tasks on ${Thread.currentThread().name}")
                    delay(100)
                }
            }
        )
        println("main ends")
    }
}

private suspend fun suspendingCoroutine(number: Int, delay: Long) {
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has finished on ${Thread.currentThread().name} ")
}
