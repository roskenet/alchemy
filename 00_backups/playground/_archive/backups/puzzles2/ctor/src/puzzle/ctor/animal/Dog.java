package puzzle.ctor.animal;

public class Dog  {

    private int size;
    
    public Dog(int size) throws Exception {
        if (size == 0) {
            throw new Exception("May not be null");
        }
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    
}
