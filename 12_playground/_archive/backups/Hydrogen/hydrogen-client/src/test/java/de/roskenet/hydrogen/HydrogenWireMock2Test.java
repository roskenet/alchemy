package de.roskenet.hydrogen;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureWireMock(port = 30123)
//@TestPropertySource(properties = {"hydrogen.url=http://localhost:${wiremock.server.port}/api/"})
//instead of @SpringBootTest to avoid running the CommandLineRunners:
@ContextConfiguration(classes = HydrogenClientApplication.class, 
    initializers = ConfigFileApplicationContextInitializer.class) 
public class HydrogenWireMock2Test {
    
    @Autowired
    private WebServiceClient webServiceClient;
    
    @Test
    public void testGetValue() throws Exception {
        String result = webServiceClient.getValue("Hello");
        assertThat(result, is("Blubber"));
    }
}
