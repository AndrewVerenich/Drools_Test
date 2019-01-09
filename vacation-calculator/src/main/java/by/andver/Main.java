package by.andver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("app-context.xml");
        EmployeeServiceImpl service= (EmployeeServiceImpl) context.getBean("employeeServiceImpl");

        Employee employee=new Employee();
        employee.setEmploymentDate(LocalDate.of(2018, Month.JANUARY,9));
        System.out.println("Working years of employee - "+ employee.getWorkingYears()+", vacations days - "+service.getVacDays(employee));

        Employee employee1=new Employee();
        employee1.setEmploymentDate(LocalDate.of(2015, Month.DECEMBER,24));
        System.out.println("Working years of employee1 - "+ employee1.getWorkingYears()+", vacations days - "+service.getVacDays(employee1));
    }
}
