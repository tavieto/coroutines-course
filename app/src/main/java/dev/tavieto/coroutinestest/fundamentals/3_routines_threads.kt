package dev.tavieto.coroutinestest.fundamentals

import kotlin.concurrent.thread

fun main() {
    println("main starts")
    threadRoutine(1, 500)
    threadRoutine (2, 300)
    Thread.sleep(1000)
    println("main ends")
}

private fun threadRoutine(num: Int, time: Long) {
    thread {
        println("Routine $num started")
        Thread.sleep(time)
        println("Routine $num has finished")
    }
}