package de.roskenet.security.demotls

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @GetMapping("/hello/{name}")
    fun helloWorld(@PathVariable("name") name : String) : Map<String, String> {
        val hashMap = HashMap<String, String>()
        hashMap.set("name", name)
        hashMap.set("value", "42")
        return hashMap
    }
}