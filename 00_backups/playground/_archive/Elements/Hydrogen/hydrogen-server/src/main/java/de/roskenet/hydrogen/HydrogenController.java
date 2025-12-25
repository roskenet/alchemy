package de.roskenet.hydrogen;

import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HydrogenController {

    private static class HydrogenResponse {
        private String elementName;
        private String elementValue;
        private ZonedDateTime elementDateTime;
        
        public HydrogenResponse(String elementName, String elementValue, ZonedDateTime elementDateTime) {
            this.elementName = elementName;
            this.elementValue = elementValue;
            this.elementDateTime = elementDateTime;
        }

        public String getElementName() {
            return elementName;
        }

        public String getElementValue() {
            return elementValue;
        }

        public ZonedDateTime getElementDateTime() {
            return elementDateTime;
        }
    }
    
    @GetMapping("/api/{value}")
    public HydrogenResponse getSomething(@PathVariable String value) {
        return new HydrogenResponse("Hydrogen", value, ZonedDateTime.now());
    }
}
