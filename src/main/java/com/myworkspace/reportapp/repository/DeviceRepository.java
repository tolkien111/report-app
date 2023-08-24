package com.myworkspace.reportapp.repository;

import com.myworkspace.reportapp.entity.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
