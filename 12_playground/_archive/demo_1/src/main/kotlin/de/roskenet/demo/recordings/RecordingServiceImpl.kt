package de.roskenet.demo.recordings

import de.roskenet.demo.Artist
import de.roskenet.demo.Recording
import de.roskenet.demo.RecordingService
import org.springframework.stereotype.Component
import java.util.Arrays.asList

@Component
class RecordingServiceImpl : RecordingService {
    override fun getRecordings(): List<Recording> {

        val recording = Recording(
            "Little Less Conversation little more Action",
            Artist(
                "Elvis",
                false
            ),
            1974u
        )
        return asList(recording)
    }
}