package interfaces;

public class Sampleapp {

    public static void main(String[] args) {
        var workerClass = new WorkerClass();
        var printable = workerClass.returnAClass();

        printable.printIt("Hallo Welt");
    }

}
