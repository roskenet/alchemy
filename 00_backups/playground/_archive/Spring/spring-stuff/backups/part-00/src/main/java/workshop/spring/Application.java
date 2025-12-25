package workshop.spring;

public class Application {
    public static void main( String[] args ) {
        Performer performer = new Juggler();

        Party app = new Party(performer);

        System.out.println(app.start());
    }
}
