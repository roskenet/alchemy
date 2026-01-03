package de.zalando.tantalum;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Option 1:
// Mock the RestClient by providing a different bean in the application context: 
@ExtendWith(SpringExtension.class) // used instead of @SpringBootTest to avoid the CommandLineRunner starting up.
@ContextConfiguration(classes = {TantalumClientApplication.class,
        MileageCounterSpringTest.TestClientConfig.class},
        initializers = ConfigFileApplicationContextInitializer.class)
public class MileageCounterSpringTest {

    @TestConfiguration
    public static class TestClientConfig {

        @Bean
        public TantalumClient tantalumClient() {
            return new TantalumClient() {
                @Override
                public List<Car> getAllCars() {
                    return Arrays.asList(new Car(1, "Volvo", "850", 450), new Car(2, "VW", "Käfer", 550));
                }
            };
        }
    }

    @Autowired
    private MileageCounter mileageCounter;

    @Test
    void testCorrectMileage() throws Exception {
        int totalMileage = mileageCounter.getTotalMileage();

        assertThat(totalMileage, is(1000));
    }

}
