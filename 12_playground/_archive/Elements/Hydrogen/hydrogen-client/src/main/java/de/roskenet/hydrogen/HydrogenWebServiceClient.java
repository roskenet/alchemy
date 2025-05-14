package de.roskenet.hydrogen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HydrogenWebServiceClient implements WebServiceClient {

    @Value("${hydrogen.url}")
    private String hydrogenUrl;

    private RestTemplate restTemplate;

    public HydrogenWebServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static class HydrogenResponse {
        private String elementName;
        private String elementValue;

        public String getElementName() {
            return elementName;
        }

        public void setElementName(String elementName) {
            this.elementName = elementName;
        }

        public String getElementValue() {
            return elementValue;
        }

        public void setElementValue(String elementValue) {
            this.elementValue = elementValue;
        }
    }

    @Override
    public String getValue(String param) {
        HydrogenResponse response = restTemplate.getForObject(hydrogenUrl + param, HydrogenResponse.class);
        return response.elementValue;
    }

}
