package com.myworkspace.reportapp.entity.report;

import com.myworkspace.reportapp.entity.customer.Customer;
import com.myworkspace.reportapp.entity.customer.Employee;
import com.myworkspace.reportapp.entity.device.Device;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "reports")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Report {

    @Id
    private UUID id;
    private String title;
    private LocalDate reportDate;
    private LocalDateTime startWork;
    private LocalDateTime endWork;
    private int overallWorkingHours;

    @Column(length = 4000) //argument wrzucić do application.properties
    private String description;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Customer customer;

    @ManyToMany(mappedBy = "reportList", fetch = FetchType.LAZY)
    private List<Device> deviceList;

    public Report(@NonNull String title,
                  @NonNull LocalDate reportDate,
                  @NonNull LocalDateTime startWork,
                  @NonNull LocalDateTime endWork,
                  int overallWorkingHours,
                  @NonNull String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.reportDate = reportDate;
        this.startWork = startWork;
        this.endWork = endWork;
        this.overallWorkingHours = overallWorkingHours;
        this.description = description;
        this.deviceList = new ArrayList<>();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return overallWorkingHours == report.overallWorkingHours && id.equals(report.id) && title.equals(report.title) && reportDate.equals(report.reportDate) && startWork.equals(report.startWork) && endWork.equals(report.endWork) && description.equals(report.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, reportDate, startWork, endWork, overallWorkingHours, description);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", reportDate=" + reportDate +
                ", startWork=" + startWork +
                ", endWork=" + endWork +
                ", overallWorkingHours=" + overallWorkingHours +
                ", description='" + description + '\'' +
                '}';
    }


}
