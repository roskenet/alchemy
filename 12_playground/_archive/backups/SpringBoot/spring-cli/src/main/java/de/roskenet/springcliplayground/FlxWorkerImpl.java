package de.roskenet.springcliplayground;

import java.util.Locale;
import org.springframework.stereotype.Component;

@Component
public class FlxWorkerImpl implements FlxWorker {

    @Override
    public String doSomething(String input) {
        return input.toLowerCase(Locale.ROOT);
    }
}
