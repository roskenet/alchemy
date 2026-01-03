package de.roskenet.demo_resource

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyResourceController {

    @GetMapping("/myresource")
    @PreAuthorize("hasAuthority('SCOPE_email')")
    fun getMyResource(): Map<String, String> {
        val hashMap = HashMap<String, String>()
        hashMap.put("answer", "42")
        return hashMap
    }
}