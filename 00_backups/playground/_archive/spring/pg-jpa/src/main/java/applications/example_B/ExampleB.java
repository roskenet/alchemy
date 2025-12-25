package applications.example_B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("applications.commons")
@EntityScan("applications.commons")
public class ExampleB implements CommandLineRunner {

    @Autowired
    private ServiceB service;

    public static void main(String[] args) {
        SpringApplication.run(ExampleB.class, args);
    }

    @Override
    public void run(String... args) {

        try {

            service.doSomething();

        } catch (Exception e) {
            System.out.println("We recovered here!");
        }

        System.out.println("What do you think?");

    }

}
