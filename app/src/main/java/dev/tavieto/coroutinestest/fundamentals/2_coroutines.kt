package dev.tavieto.coroutinestest.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

// The Jobs are grouped by joinAll, calling
// "join" method from all Job listed. The
// "join" method does the current coroutine
// created by "runBlocking" await for your result
// before execute the next line. That way, joinAll
// assure that Jobs are finished before execute the
// next line off code.

fun main() {
    return runBlocking {
        println("main starts")
        joinAll(
            async { coroutine(1, 1000) },
            async { coroutine(2, 500) }
        )
        println("main ends")
    }
}

// The Jobs created by async function are executed
// sequentially. As the coroutine function have a
// delay, the log "main ends" appears before the
// prints from coroutine function.

//fun main() {
//    return runBlocking {
//        println("main starts")
//        async { coroutine(1, 1000) }
//        async { coroutine(2, 500) }
//        println("main ends")
//    }
//}

// Behaving exactly as a routine

//fun main() {
//    return runBlocking {
//        println("main starts")
//        coroutine(1, 1000)
//        coroutine(2, 500)
//        println("main ends")
//    }
//}

private suspend fun coroutine(number: Int, delay: Long) {
    println("Coroutine $number starts work")
    delay(delay)
    println("Coroutine $number has finished")
}