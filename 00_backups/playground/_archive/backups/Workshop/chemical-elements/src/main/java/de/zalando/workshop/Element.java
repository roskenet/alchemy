package de.zalando.workshop;

public abstract class Element {

    private String name;
    private int atomicNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }
}
