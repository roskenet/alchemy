package de.zalando.webdemo

import org.springframework.http.HttpStatus
import org.zalando.riptide.Bindings
import org.zalando.riptide.Http
import org.zalando.riptide.Navigators

class CatFact {
    val fact: String = ""
}

class CatFactClient(val client: Http) {
    fun getAFact(): String {
        var catFact = ""

        client.get("/fact")
            .dispatch(
                Navigators.series(),
                Bindings.on(HttpStatus.Series.SUCCESSFUL).call(
                    CatFact::class.java
                ) {
                    catFact = it.fact
                }).join();

        return catFact
    }
}
