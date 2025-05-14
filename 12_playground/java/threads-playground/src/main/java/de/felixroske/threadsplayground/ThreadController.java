package de.felixroske.threadsplayground;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {

    @PostMapping("/thread")
    public void postThread(@RequestBody ThreadConfig threadConfig) {
        var workerThing = new WorkerThing(threadConfig.name());
        Thread thread = new Thread(workerThing);
        thread.start();
    }
}
