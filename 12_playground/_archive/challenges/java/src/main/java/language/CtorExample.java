package language;

public class CtorExample {

    private String myString;

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public static void main(String[] args) {
        var ctorExample = new CtorExample();
    }
}
