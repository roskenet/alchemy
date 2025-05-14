package springstuff.springcomponentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springstuff.beans.AppConfig;
import springstuff.beans.JugglerApp;

public class Main {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.getBean(JugglerApp.class).doSomething();
    }
}
