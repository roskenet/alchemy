public class PgEquals {

    public static void main(String[] args) {
        var pgEqualsApp = new PgEquals();
        pgEqualsApp.doSomething();
    }

    class SomeClass {
        private String myString;
        private int myInt;

        public SomeClass(String myString, int myInt) {
            this.myString = myString;
            this.myInt = myInt;
        }

        public String getMyString() {
            return myString;
        }

        public int getMyInt() {
            return myInt;
        }
    }

    public void doSomething() {
        var someClass = new SomeClass("Ostzonensuppenwürfel verursachen Krebs.", 42);
        var equals = someClass.equals(null);
        System.out.println("Equals returns: " + equals);
    }
}
