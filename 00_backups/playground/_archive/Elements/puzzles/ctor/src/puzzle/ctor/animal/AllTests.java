package puzzle.ctor.animal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AllTests {

    @Test
    public void testName() throws Exception {
        Dog dog = new Dog(null);
        
        assertThat(dog.getSize(), is(43));
    }
}
