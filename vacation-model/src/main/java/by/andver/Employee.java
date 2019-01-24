package by.andver;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employee {
    private String name;
    private String surname;
    private int age;
    private LocalDate employmentDate;
    private int vacationsDays;
    private int illDays;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getWorkingYears() {
        return ChronoUnit.YEARS.between(LocalDate.from(employmentDate), LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public int getVacationsDays() {
        return vacationsDays;
    }

    public void setVacationsDays(int vacationsDays) {
        this.vacationsDays = vacationsDays;
    }

    public int getIllDays() {
        return illDays;
    }

    public void setIllDays(int illDays) {
        this.illDays = illDays;
    }
}
