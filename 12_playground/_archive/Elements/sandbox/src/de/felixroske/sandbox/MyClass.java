package de.felixroske.sandbox;

public class MyClass {

    public static void main(String[] args) {

        int currentInt;

        MyClass myClass = new MyClass();
        
        
        myClass.doSomething(Integer.valueOf("42"));
    }

    public Integer doSomething(int x) {

        switch (x) {
        case 1:
            
            
        }
        return Integer.valueOf(x);
    }
}
