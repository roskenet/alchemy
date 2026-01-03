package de.roskenet.nitrogen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@EnableMethodSecurity
class NitrogenApplication {

	@GetMapping("/myresource")
	@PreAuthorize("hasAnyAuthority('email')")
	fun getMyResource(): Map<String, String> {
		val hashMap = HashMap<String, String>()
		hashMap.put("answer", "42")
		return hashMap
	}
}

fun main(args: Array<String>) {
	runApplication<NitrogenApplication>(*args)
}
