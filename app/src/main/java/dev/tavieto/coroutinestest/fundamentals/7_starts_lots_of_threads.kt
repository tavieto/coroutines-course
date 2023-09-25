package dev.tavieto.coroutinestest.fundamentals

import kotlin.concurrent.thread

// System will crash with OutOfMemoryError
fun main() {
    repeat(1_000_000) {
        thread {
            Thread.sleep(5000)
            print(".")
        }
    }
}

