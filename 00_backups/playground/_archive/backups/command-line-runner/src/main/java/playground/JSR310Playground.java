package playground;

import java.time.Instant;

public class JSR310Playground {
    public static void main(String[] args) {
        System.out.println("Hello JS310 Playground:");
        playWithJSR310();
    }

    public static void playWithJSR310() {
        Instant instant = Instant.parse("2020-10-01T00:00:00Z");
        System.out.println(instant.toString());
    }
}

