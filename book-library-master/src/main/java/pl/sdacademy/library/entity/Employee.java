package pl.sdacademy.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends Person{

    @Enumerated(EnumType.STRING)
    @Column(name = "job_title", nullable = false)
    private EmployeeJobTitle jobTitle;

    public EmployeeJobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(EmployeeJobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }
}
