package de.zalando.quiz;

class AClass {
    public AClass() {
        System.out.println("Black");
    }
}

class BClass extends AClass {
    public BClass() {
        System.out.println("Grey");
    }
}

public class QuizC {
    public static void main(String[] args) {
        AClass aClass = new AClass();

        AClass bClass = new BClass();
    }
}
