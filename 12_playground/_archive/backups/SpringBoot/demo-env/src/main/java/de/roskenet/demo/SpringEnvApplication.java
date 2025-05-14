package de.roskenet.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEnvApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringEnvApplication.class, args);
    }

    @Autowired
    private EnvApplicationConfig envApplicationConfig;

    @Autowired
    private EnvApplicationBean envApplicationBean;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("You have configured: " + envApplicationConfig.getSomeString());
        System.out.println("The application Bean: " + envApplicationBean.getTheEnvString());
    }
}
