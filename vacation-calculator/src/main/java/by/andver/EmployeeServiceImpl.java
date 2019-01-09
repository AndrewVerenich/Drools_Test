package by.andver;

import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl {
    @Autowired
    private StatelessKnowledgeSession session;

    public int getVacDays (Employee employee){
        session.execute(employee);
        return employee.getVacationsDays();
    }
}
