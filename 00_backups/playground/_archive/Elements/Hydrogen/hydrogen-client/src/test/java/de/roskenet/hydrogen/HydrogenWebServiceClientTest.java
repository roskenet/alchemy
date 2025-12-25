package de.roskenet.hydrogen;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

// Possibility 1:
// We have the server application run locally and only test the WebServiceClient bean:
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"hydrogen.url=http://localhost:8080/api/"})
public class HydrogenWebServiceClientTest {

    @Configuration
    public static class WebServiceClientConfig {
        
        @Bean
        public WebServiceClient webServiceClient() {
            RestTemplateBuilder builder = new RestTemplateBuilder();
            return new HydrogenWebServiceClient(builder);
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
