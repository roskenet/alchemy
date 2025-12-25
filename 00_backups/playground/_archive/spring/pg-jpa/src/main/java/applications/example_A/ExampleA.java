package applications.example_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("applications.commons")
@EntityScan("applications.commons")
public class ExampleA implements CommandLineRunner {

    @Autowired
    private ServiceA service;

    public static void main(String[] args) {
        SpringApplication.run(ExampleA.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       service.doSomething();

    }
}
