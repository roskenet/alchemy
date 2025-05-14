package de.zalando.tantalum;

import org.springframework.stereotype.Component;

@Component
public class MileageCounter {

    private TantalumClient tantalumClient;
    
    public MileageCounter(TantalumClient tantalumClient) {
        this.tantalumClient = tantalumClient;
    }
    
    public int getTotalMileage() {
        return tantalumClient.getAllCars().stream()
            .mapToInt(Car::getMileage)
            .sum();
    }
}
