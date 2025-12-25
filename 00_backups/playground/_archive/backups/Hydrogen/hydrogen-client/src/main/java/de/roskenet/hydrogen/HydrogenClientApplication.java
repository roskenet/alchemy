package de.roskenet.hydrogen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HydrogenClientApplication implements CommandLineRunner {
    
    @Autowired
    private WebServiceClient webServiceClient;
    
	public static void main(String[] args) {
		SpringApplication.run(HydrogenClientApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Hello World! Let's call the service:");
        String value = webServiceClient.getValue("Hallo");
        
        System.out.println("It answered: " + value);
    }

}
