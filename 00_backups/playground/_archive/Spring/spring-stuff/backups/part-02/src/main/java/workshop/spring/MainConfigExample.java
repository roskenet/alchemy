package workshop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import workshop.spring.beans.PartyConfig;
import workshop.spring.beans.Party;

public class MainConfigExample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PartyConfig.class);
        Party party = context.getBean(Party.class);

        String performance = party.start();
        System.out.println(performance);
    }
}
