package de.zalando.tantalum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TantalumClientApplication implements CommandLineRunner {

    @Autowired
    private MileageCounter mileageCounter; 
    
	public static void main(String[] args) {
		SpringApplication.run(TantalumClientApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        int totalMileage = mileageCounter.getTotalMileage();
        
        System.out.println("Total mileage of your cars is: " + totalMileage + "k km.");

    }

}
