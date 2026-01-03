package de.zalando.tantalum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;
    
    @GetMapping("/api/cars")
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }
}
