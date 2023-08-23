package com.myworkspace.reportapp.entity.device;

import com.myworkspace.reportapp.entity.EntityTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest extends EntityTest {

    @Test
    void shouldSavaDevice(){
        //GIVEN
        final var deviceBase = new DeviceBase("ScanBox 6130", "1ASD230421", 3);
        final var device = new Device("20230102665577", deviceBase);

        //WHEN
        persistObject(device);


        //THEN
        final var readDevice = em.find(Device.class, device.getId());
        assertEquals(deviceBase, readDevice.getDeviceBase());
        assertEquals(device, readDevice);

    }

}