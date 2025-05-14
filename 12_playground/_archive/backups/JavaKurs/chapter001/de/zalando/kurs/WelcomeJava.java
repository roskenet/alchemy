package de.zalando.kurs;

public class WelcomeJava {

    static class InternalClass {
        private final String myString;

        public InternalClass(String myString) {
            this.myString = myString;
        }

        public String getMyString() {
            return myString;
        }

    }

    public static void main(String[] args) {
        var retString = doSomething();
        System.out.println("Hello World, " + retString);
    }

    private static String doSomething() {
        var internalClass = new InternalClass("Something");
        return internalClass.getMyString();
    }
}
