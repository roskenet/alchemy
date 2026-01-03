package workshop.spring.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import workshop.spring.beans.Performer;

@SpringBootApplication
public class Party implements CommandLineRunner {

    @Autowired
    private Performer performer;

    public static void main(String[] args) {
        SpringApplication.run(Party.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        performer.doSomething();
    }
}
