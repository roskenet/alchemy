package de.felixroske;

import static de.felixroske.WorkerClassKt.*;

public class JClasses {

    private String flxImportantString = "";

    public void doSomething() {
        System.out.println("We have here: " + flxImportantString);

        var flxKtClass = new FlxKtClass("Hello");

        var s = flxKtClass.giveMeTheArg();

        WorkerClassKt.doSomething(flxKtClass, 42);
    }
}
