package by.andver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {

    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("app-context.xml");
        EmployeeServiceImpl service= (EmployeeServiceImpl) context.getBean("employeeServiceImpl");

        Employee employee=new Employee();
        employee.setEmploymentDate(new Date());

        Employee employee1=new Employee();
        employee1.setEmploymentDate(new Date());

        System.out.println(service.getVacDays(employee));
        System.out.println(service.getVacDays(employee1));


    }
}
