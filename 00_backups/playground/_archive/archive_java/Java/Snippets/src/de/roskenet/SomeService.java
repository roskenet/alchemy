package de.roskenet;

import de.roskenet.Main.TheNestedClass;
import java.util.Locale;

public class SomeService {
    public void someAction() {
        var theNestedClass = new TheNestedClass();
        var myVariable = "This is a var".toLowerCase(Locale.ROOT);

        System.out.println(myVariable);
    }
}
