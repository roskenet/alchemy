package springstuff.springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        var applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

//        var theApp = (TheApp) applicationContext.getBean("junglerApp");
//        or:
//        var theApp = applicationContext.getBean(TheApp.class, "jugglerApp");
//        or simply:

        var theApp = applicationContext.getBean(TheApp.class);

        theApp.doSomething();
    }
}
