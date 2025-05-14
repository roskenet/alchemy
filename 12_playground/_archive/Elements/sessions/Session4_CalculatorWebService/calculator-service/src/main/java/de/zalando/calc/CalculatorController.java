package de.zalando.calc;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    public class CalculatorResponse {
        private BigDecimal result;

        public BigDecimal getResult() {
            return result;
        }

        public void setResult(BigDecimal result) {
            this.result = result;
        }
        
    }
    
    @GetMapping("/api/result/{number}") 
    public CalculatorResponse getSomething(@PathVariable("number") BigDecimal number) {
        CalculatorResponse response = new CalculatorResponse();
        response.setResult(number.multiply(BigDecimal.valueOf(42L)));
        
        return response;
    }
}
