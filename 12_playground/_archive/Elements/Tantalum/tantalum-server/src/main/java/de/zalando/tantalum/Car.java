package de.zalando.tantalum;

public class Car {

    private int id;
    private String manufacturer;
    private String model;
    private int mileage;

    public Car(int id,
               String manufacturer,
               String model,
               int mileage) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.mileage = mileage;
    }
    
    public int getId() {
        return id;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

}
