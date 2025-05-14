package de.roskenet.oxygen;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegerController {

    public static class NumberResponse {

        private int number;
        private Date date;

        public NumberResponse(int theNumber) {
            this.number = theNumber;
            this.date = new Date();
        }

        public int getNumber() {
            return number;
        }

        public Date getDate() {
            return date;
        }

    }

    @GetMapping("/api/ints/{int}")
    public NumberResponse getNumber(@PathVariable("int") int number) {
        return new NumberResponse(number);
    }
}
