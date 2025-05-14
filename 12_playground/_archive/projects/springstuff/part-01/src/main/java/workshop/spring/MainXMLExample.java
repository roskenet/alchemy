package workshop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import workshop.spring.beans.Party;

public class MainXMLExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        Party party = context.getBean(Party.class);

        var result = party.start();
        System.out.println(result);
    }
}
