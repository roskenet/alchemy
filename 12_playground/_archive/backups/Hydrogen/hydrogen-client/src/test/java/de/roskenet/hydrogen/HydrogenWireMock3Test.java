package de.roskenet.hydrogen;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureWireMock(port = 9999)
@ContextConfiguration(classes = HydrogenClientApplication.class, 
    initializers = ConfigFileApplicationContextInitializer.class) 
public class HydrogenWireMock3Test {
            
            @Autowired
            private WebServiceClient webServiceClient;
    
            @Before
            public void setUpWiremock() {
                stubFor(get(urlEqualTo("/api/testme"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("{\"elementValue\": \"blah\"}")));
            }
            
            @Test
            public void testGetValue() throws Exception {
                String result = webServiceClient.getValue("testme");
                assertThat(result, is("blah"));
            }
}
