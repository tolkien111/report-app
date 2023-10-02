package com.myworkspace.reportapp.entity.device;

import com.myworkspace.reportapp.entity.customer.Customer;
import com.myworkspace.reportapp.entity.report.Report;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "devices")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Device {

    @Id
    private UUID id;
    private String serialNumber;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "device_base_id")
    private DeviceBase deviceBase;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "devices_reports",
            joinColumns = @JoinColumn(name = "device_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"))
    private List<Report> reportList;

    @ManyToOne
    private Customer customer;


    public Device(@NonNull String serialNumber,
                  @NonNull DeviceBase deviceBase) {
        this.id = UUID.randomUUID();
        this.serialNumber = serialNumber;
        this.deviceBase = deviceBase;
        this.reportList = new ArrayList<>();
    }

    public void addReport(Report report) {
        if (report != null && !reportList.contains(report)) {
            report.getDeviceList().add(this);
            reportList.add(report);
        }
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(serialNumber, device.serialNumber) && Objects.equals(deviceBase, device.deviceBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, deviceBase);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", deviceBase=" + deviceBase +
                '}';
    }
}
