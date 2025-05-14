package de.roskenet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        MyClass myClass = new MyClass();
        myClass.setName("Donald Duck");

        doSomething(myClass);
    }

    private static void doSomething(MyClass theClass) {
        System.out.println(theClass.getName());
    }

}
