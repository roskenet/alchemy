package springstuff.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JugglerApp {

    @Autowired
    private Juggler juggler;

//    This would work, too:
//    Spring would try to do constructor injection using a
//    juggler Bean.
//    public JugglerApp(Juggler juggler) {
//        this.juggler = juggler;
//    }

    public void doSomething() {
        System.out.println(juggler.perform());
    }
}
