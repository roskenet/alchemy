package de.roskenet.hydrogen;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokPlayground {

    public static void main(String[] args) {
        LombokPlayground lombokPlayground = new LombokPlayground();
        lombokPlayground.logSomethingOut();
    }

    @Data
    class SomeClassForLogging {
       private String someString;
       private int someInt;
       private boolean someBool;
    }

    public void logSomethingOut() {

        SomeClassForLogging someClassForLogging = new SomeClassForLogging();
        someClassForLogging.someString = "Hallo Welt";

        log.info("The class logs out as: {}", someClassForLogging);

        SomeClassForLogging anotherClassForLogging = new SomeClassForLogging();


    }

}
