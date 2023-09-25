package dev.tavieto.coroutinestest.fundamentals

fun main() {
    println("main starts")
    routine(1, 2000)
    routine(2, 100)
    println("main ends")
}

private fun routine(num: Int, time: Long) {
    println("Routine $num started")
    Thread.sleep(time)
    println("Routine $num has finished")
}