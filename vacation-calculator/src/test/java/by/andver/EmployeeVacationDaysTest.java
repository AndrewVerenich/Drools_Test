package by.andver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class EmployeeVacationDaysTest {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    public void oneYearEmployedTest() {
        Employee employee = new Employee();
        employee.setEmploymentDate(LocalDate.now().minusYears(1));
        Assert.assertEquals(24, employeeService.getVacDays(employee));
    }

    @Test
    public void treeYearEmployedTest() {
        Employee employee = new Employee();
        employee.setEmploymentDate(LocalDate.now().minusYears(3));
        Assert.assertEquals(28, employeeService.getVacDays(employee));
    }
}
