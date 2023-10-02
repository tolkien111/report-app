package com.myworkspace.reportapp.entity.report;

import com.myworkspace.reportapp.entity.EntityTest;
import com.myworkspace.reportapp.entity.customer.Customer;
import com.myworkspace.reportapp.entity.customer.Employee;
import com.myworkspace.reportapp.entity.device.Device;
import com.myworkspace.reportapp.entity.device.DeviceBase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest extends EntityTest {

    @Test
    void shouldSaveReport() {
        //GIVEN
        final var report = new Report("Maintenance and Repair",
                LocalDate.of(2023, 1, 11),
                LocalDateTime.of(2023, 1, 9, 12, 30),
                LocalDateTime.of(2023, 1, 11, 15, 30),
                12,
                "Maintenance and Repair ScanBox 6130");
        //WHEN
        persistObject(report);
        //THEN
        final var readReport = em.find(Report.class, report.getId());
        assertEquals(report, readReport);
    }

    @Test
    void shouldSaveReportWhenEmployeeCustomerAndDeviceAreSavedInDb() {
        //GIVEN
        final var employee = new Employee("yahoo@wp.pl",
                "669876222",
                "Alan",
                "James",
                "bbb");
        final var customer = new Customer("gmail@wp.pl",
                "669876333",
                "IT AG",
                "Jerozolimskie 100, 02-017, Warsaw, Poland");
        final var deviceBase = new DeviceBase("ScanBox 6130",
                "1ASD230421",
                3);
        final var device = new Device("20230102665577",
                deviceBase);

        final var report = new Report("Maintenance and Repair",
                LocalDate.of(2023, 1, 11),
                LocalDateTime.of(2023, 1, 9, 12, 30),
                LocalDateTime.of(2023, 1, 11, 15, 30),
                12,
                "Maintenance and Repair ScanBox 6130");

        //WHEN
        //save in db
        persistObject(employee);
        persistObject(customer);
        persistObject(device);
        //add report to objects
        employee.addReport(report);
        customer.addReport(report);
        device.addReport(report);
        //update, save db and clear cache
        em.merge(employee);
        em.merge(customer);
        em.merge(device);
        em.flush();
        em.clear();

        //read employee, customer and device with report and report
        final var readEmployee = em.find(Employee.class, employee.getId());
        final var readCustomer = em.find(Customer.class, customer.getId());
        final var readDevice = em.find(Device.class, device.getId());
        final var readReport = em.find(Report.class, report.getId());
        //THEN
        assertEquals(report, readEmployee.getReportList().get(0));
        assertEquals(report, readCustomer.getReportList().get(0));
        assertEquals(report, readDevice.getReportList().get(0));
        assertEquals(device, readReport.getDeviceList().get(0));
        assertEquals(report, readReport);


    }

}