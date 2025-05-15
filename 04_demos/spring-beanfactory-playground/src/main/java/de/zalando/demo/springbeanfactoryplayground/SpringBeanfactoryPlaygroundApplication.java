package de.zalando.demo.springbeanfactoryplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBeanfactoryPlaygroundApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanfactoryPlaygroundApplication.class, args);
    }


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(applicationContext.getId());
        System.out.println(applicationContext.getDisplayName());

    }
}
