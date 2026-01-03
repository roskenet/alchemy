package de.roskenet.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class AnotherDevBean implements AnotherBean {

    @Override
    public String showAnotherText() {
        return "This is the AnotherDevBean!";
    }
}
