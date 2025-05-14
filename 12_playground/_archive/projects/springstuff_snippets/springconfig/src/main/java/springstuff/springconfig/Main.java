package springstuff.springconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springstuff.springconfig.config.JugglerAppConfig;

public class Main {
    public static void main(String[] args) {
        var annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JugglerAppConfig.class);
        var theApp = annotationConfigApplicationContext.getBean(TheApp.class);
        theApp.doSomething();
    }
}
