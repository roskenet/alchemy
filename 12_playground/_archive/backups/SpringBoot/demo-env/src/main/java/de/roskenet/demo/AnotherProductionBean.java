package de.roskenet.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class AnotherProductionBean implements AnotherBean {

    @Override
    public String showAnotherText() {
        return "This is the ProductionBean";
    }
}
