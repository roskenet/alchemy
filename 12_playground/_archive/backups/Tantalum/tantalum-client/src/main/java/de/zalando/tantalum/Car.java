package de.zalando.tantalum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    private int id;
    private String manufacturer;
    private String model;
    private int mileage;

    public Car() {
        
    }
    
    public Car(int id, String manufacturer, String model, int mileage) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.mileage = mileage;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}
