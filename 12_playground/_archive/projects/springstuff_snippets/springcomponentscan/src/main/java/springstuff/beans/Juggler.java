package springstuff.beans;

import org.springframework.stereotype.Component;

@Component
public class Juggler {
    public String perform() {
        return "I am juggling!";
    }
}
