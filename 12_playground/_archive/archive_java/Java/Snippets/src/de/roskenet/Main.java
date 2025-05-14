package de.roskenet;

public class Main {

    public static class TheNestedClass {

        public static void doSomething() {
            System.out.println("Hello World");
        }
    }

public static void main(String[] args) {
        String[] myArray = {"eins", "zwei", "drei"};

        doSomething(myArray);
        TheNestedClass.doSomething();
        
    }

    private static void doSomething(String[] myArray) {
        for (String s : myArray) {
            System.out.println(s);
        }
    }
}
