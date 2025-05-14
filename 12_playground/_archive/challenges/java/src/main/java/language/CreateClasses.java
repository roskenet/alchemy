package language;

public class CreateClasses {

    private CreateClasses() {
        System.out.println("I was called!");
    }
    protected String something;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        CreateClasses myClass = (CreateClasses) Class.forName("language.CreateClasses").newInstance();
        myClass.something = "Hackbraten";

        System.out.println(myClass.something);
    }

}
