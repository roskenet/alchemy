package de.roskenet.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
interface DemoApi {

    @GetMapping("/recordings")
    fun getRecordings(): List<Recording>
}

@Component
class DemoApiImpl(val recordingService: RecordingService): DemoApi {

    override fun getRecordings(): List<Recording> {
       return recordingService.getRecordings()
    }

}