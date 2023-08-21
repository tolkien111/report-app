package com.myworkspace.reportapp.entity.device;


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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private List<Report> reportList;


    public Device(@NonNull String serialNumber,@NonNull DeviceBase deviceBase) {
        this.id = UUID.randomUUID();
        this.serialNumber = serialNumber;
        this.deviceBase = deviceBase;
        this.reportList = new ArrayList<>();
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
                ", reportList=" + reportList +
                '}';
    }
}
