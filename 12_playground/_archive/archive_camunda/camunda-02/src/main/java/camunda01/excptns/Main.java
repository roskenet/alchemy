package javapg.excptns;

public class Main {

    public static void main(String[] args) throws MyException {
        System.out.println("Fun with Exceptions");

//        MyException myException1 = new MyException();
        MyException myException2 = new MyException("My Message");

    }
}
