package basics

import de.hilling.coroutines.common.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch ( block = {
        delay(500)
        log("World!")
        delay(100)
        log("something else")
    })

    log("Hello,")
    Thread.sleep(1000L)
}
