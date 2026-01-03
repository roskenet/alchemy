package de.roskenet.shadows;

public class MySubClass extends MySuperClass {

    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MySubClass{" +
                "id='" + id + '\'' +
                '}';
    }
}
