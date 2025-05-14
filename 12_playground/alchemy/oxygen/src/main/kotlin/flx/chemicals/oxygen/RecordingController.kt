package flx.chemicals.oxygen

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RecordingController {

    @GetMapping("/recordings")
    fun getRecordings(): List<Recording> =
        listOf(Recording("Amy Winehouse", "Back to Black"))

}