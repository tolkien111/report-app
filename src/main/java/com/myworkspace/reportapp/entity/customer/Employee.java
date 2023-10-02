package com.myworkspace.reportapp.entity.customer;

import com.myworkspace.reportapp.entity.report.Report;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("EMPLOYEE")
@NoArgsConstructor
@Getter
public class Employee extends User {

    private String firstName;
    private String lastName;
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Report> reportList;

    public Employee(@NonNull String email,
                    @NonNull String phoneNumber,
                    @NonNull String firstName,
                    @NonNull String lastName,
                    @NonNull String password) {
        super(email, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.reportList = new ArrayList<>();
    }

    public void addReport(Report report) {
        if (report != null && !reportList.contains(report)) {
            report.setEmployee(this);
            reportList.add(report);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }
}
