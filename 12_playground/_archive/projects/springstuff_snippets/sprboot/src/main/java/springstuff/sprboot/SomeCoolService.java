package springstuff.sprboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import springstuff.sprboot.converter.MagicConverter;

@Component
public class SomeCoolService {

    @Autowired
    private MagicConverter magicConverter;

    @Value("${magicstring:empty}")
    private String theMagicString;

    public String getTheMagicString() {
        return magicConverter.convert(theMagicString);
    }
}
