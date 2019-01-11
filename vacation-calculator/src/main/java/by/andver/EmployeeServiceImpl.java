package by.andver;

import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl {

    private final StatelessKieSession session;

    @Autowired
    public EmployeeServiceImpl(final StatelessKieSession session) {
        this.session = session;
    }

    public int getVacDays (Employee employee){
        session.execute(employee);
        return employee.getVacationsDays();
    }
    public int getIllDays(Employee employee){
        session.execute(employee);
        return employee.getIllDays();
    }
}
