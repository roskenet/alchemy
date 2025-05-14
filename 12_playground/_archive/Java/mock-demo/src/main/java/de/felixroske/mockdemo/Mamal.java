package de.felixroske.mockdemo;

public class Mamal extends Animal implements Moveable {
    @Override
    public void move(long distance) {
        System.out.println("Moving: " + distance);
    }
}
