package de.roskenet.hydrogen;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

// Possibility 2:
// We mock the WebServiceClient bean here.
@RunWith(SpringRunner.class)
public class HydrogenBeanMockTest {
 
    @Configuration
    public static class WebServiceClientConfig {
        
        @Bean
        public WebServiceClient webServiceClient() {
            return new WebServiceClient() {
                
                @Override
                public String getValue(String param) {
                    return "Felix";
                }
            };
        }
    }
    
    @Autowired
    private WebServiceClient webServiceClient;
    
    @Test
    public void testGetValue() throws Exception {
        String result = webServiceClient.getValue("Felix");
        assertThat(result, is("Felix"));
    }
    
}

