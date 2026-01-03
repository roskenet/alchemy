package workshop.spring.party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SummerParty implements CommandLineRunner {

    @Autowired
    private Performer performer;

    public void start() {
        performer.doSomething();
    }

    @Override
    public void run(String... args) throws Exception {
        start();
    }
}
