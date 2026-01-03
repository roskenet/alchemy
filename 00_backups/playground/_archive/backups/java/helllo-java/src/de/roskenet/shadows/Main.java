package de.roskenet.shadows;

public class Main {

    public static void main(String[] args) {
        var mySubClassOne = new MySubClass();
        mySubClassOne.setId("ONE");

        var mySubClassTwo = new MySubClass();
        mySubClassTwo.setId("TWO");

        var equals = mySubClassOne.equals(mySubClassTwo);

        if (equals == true) {
            System.out.println("I am TRUE!");
        }
    }

}
