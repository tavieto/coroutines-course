package dev.tavieto.coroutinestest.fundamentals

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() {
    return runBlocking {
        println("main starts")
        joinAll(async { coroutineWithThreadInfo(1, 500) },
            async { coroutineWithThreadInfo(2, 300) })
        println("main ends")
    }
}

private fun coroutineWithThreadInfo(number: Int, delay: Long) {
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    Handler(Looper.getMainLooper()).postDelayed(
            {
                println("Coroutine $number has finished on ${Thread.currentThread().name} ")
            }, delay
        )
}
