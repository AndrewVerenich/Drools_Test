package by.andver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {
        ApplicationContext context=new ClassPathXmlApplicationContext("app-context.xml");
        EmployeeServiceImpl service= (EmployeeServiceImpl) context.getBean("employeeServiceImpl");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        Employee employee=new Employee();
        employee.setEmploymentDate(sdf.parse("06/24/2017"));
        System.out.println("Working days of employee:"+ employee.getWorkingDays()+", vacations days - "+service.getVacDays(employee));

        Employee employee1=new Employee();
        employee1.setEmploymentDate(sdf.parse("06/24/2015"));
        System.out.println("Working days of employee1:"+ employee1.getWorkingDays()+", vacations days - "+service.getVacDays(employee1));
    }
}
