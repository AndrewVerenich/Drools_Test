package by.andver;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("app-context.xml");


        KieBase kieBase= (KieBase) context.getBean("drl_kiesample");
        KieSession kieSession=kieBase.newKieSession();

        Employee employee=new Employee();
        employee.setAge(25);

        Employee employee1=new Employee();
        employee1.setAge(18);



        kieSession.insert(employee);
        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
