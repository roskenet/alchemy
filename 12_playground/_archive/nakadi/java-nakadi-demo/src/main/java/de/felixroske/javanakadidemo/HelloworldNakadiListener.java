package de.felixroske.javanakadidemo;

import org.springframework.stereotype.Component;
import org.zalando.spring.boot.fahrschein.nakadi.NakadiListener;

import java.util.List;
import java.util.Locale;

@Component
public class HelloworldNakadiListener implements NakadiListener<HelloWorld> {
    @Override
    public Class<HelloWorld> getEventType() {
        return HelloWorld.class;
    }

    @Override
    public void accept(List<HelloWorld> events) {
        for (HelloWorld o : events) {
            System.out.println(o.getName().toUpperCase(Locale.GERMAN));
        }
    }
}
