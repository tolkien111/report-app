package com.myworkspace.reportapp.entity.report;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table (name = "reports")
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

    @Column(length = 4000)
    private String description;

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
