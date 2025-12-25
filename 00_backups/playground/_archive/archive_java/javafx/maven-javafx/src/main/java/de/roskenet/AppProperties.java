package de.roskenet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppProperties {
    public static Properties readProperties(String fileName) {
        Properties prop = new Properties();
        try(InputStream inputStream = AppProperties.class.getClassLoader().getResourceAsStream(fileName)) {
            prop.load(inputStream);
            log.warn("inputStream");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
