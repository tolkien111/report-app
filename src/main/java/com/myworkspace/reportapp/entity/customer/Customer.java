package com.myworkspace.reportapp.entity.customer;

import com.myworkspace.reportapp.entity.device.Device;
import com.myworkspace.reportapp.entity.report.Report;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("CUSTOMER")
@NoArgsConstructor
@Getter
public class Customer extends User {

    private String name;
    private String address;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Device> deviceList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Report> reportList;

    public Customer(@NonNull String email,
                    @NonNull String phoneNumber,
                    @NonNull String name,
                    @NonNull String address) {
        super(email, phoneNumber);
        this.name = name;
        this.address = address;
        this.deviceList = new ArrayList<>();
        this.reportList = new ArrayList<>();
    }

    public void addDevice(Device device) {
        if (device != null && !deviceList.contains(device))
            device.setCustomer(this);
        deviceList.add(device);
    }

    public void addReport(Report report) {
        if (report != null && !reportList.contains(report))
            report.setCustomer(this);
        reportList.add(report);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) && address.equals(customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString(); //auditing - przygotować na poziomie encji
    }
}
