package com.myworkspace.reportapp.repository;

import com.myworkspace.reportapp.entity.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
}
