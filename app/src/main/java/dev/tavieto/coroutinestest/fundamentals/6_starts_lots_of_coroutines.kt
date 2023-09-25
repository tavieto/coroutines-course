package dev.tavieto.coroutinestest.fundamentals

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    return runBlocking {
        repeat(1_000_000) {
            // Launch function creates a new Coroutine
            launch {
                delay(5000)
                print(".")
            }
        }
    }
}

