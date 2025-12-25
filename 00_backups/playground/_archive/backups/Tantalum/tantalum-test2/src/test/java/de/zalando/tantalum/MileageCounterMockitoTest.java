package de.zalando.tantalum;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//Option 2:
//Mock the RestClient with Mockito
@ExtendWith(SpringExtension.class) // used instead of @SpringBootTest to avoid the CommandLineRunner starting up.
@ContextConfiguration(classes = {TantalumClientApplication.class},
                   initializers = ConfigFileApplicationContextInitializer.class) 
public class MileageCounterMockitoTest {

    @Mock
    private TantalumClient tantalumClient;
    
    @InjectMocks
    private MileageCounter mileageCounter;
    
    private List<Car> mockedCarList = Arrays.asList(new Car(1, "Volvo", "Convertible", 450), new Car(2, "VW", "Käfer", 500)); 
    
    @Test
    void testClientCall() {
        when(tantalumClient.getAllCars()).thenReturn(mockedCarList);
        
        mileageCounter.getTotalMileage();
        
        verify(tantalumClient, times(1)).getAllCars();
    }
    
	@Test
	void testCorrectMileage() {
	    when(tantalumClient.getAllCars()).thenReturn(mockedCarList);
	    
	    int totalMileage = mileageCounter.getTotalMileage();
	    
        assertThat(totalMileage, is(950));
	}

}
