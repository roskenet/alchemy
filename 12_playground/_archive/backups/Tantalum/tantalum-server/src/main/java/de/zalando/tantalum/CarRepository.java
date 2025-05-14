package de.zalando.tantalum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CarRepository {

    private Map<Integer, Car> carMap = new HashMap<>();
    
    public CarRepository() {
      carMap.put(1, new Car(1, "Mercedes", "190", 20));  
      carMap.put(2, new Car(2, "BMW", "i8", 125));
      carMap.put(3, new Car(3, "Ford", "Fiesta", 320));
    }
    
    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        carMap.forEach((k, v) -> carList.add(v));
        return carList;
    }
    
    public void addCar(int id, Car newCar) {
        carMap.put(id, newCar);
    }
    
    public Car getCar(int id) {
        return carMap.get(id);
    }
}
