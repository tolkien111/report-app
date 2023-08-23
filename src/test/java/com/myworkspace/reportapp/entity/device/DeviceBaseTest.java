package com.myworkspace.reportapp.entity.device;

import com.myworkspace.reportapp.entity.EntityTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceBaseTest extends EntityTest {

    @Test
    void shouldSaveDeviceBase(){
        //GIVEN
        final var deviceBase = new DeviceBase("ScanBox 6130", "1ASD230421", 3);
        //WHEN
        persistObject(deviceBase);
        //THEN
        final var readDeviceBase = em.find(DeviceBase.class, deviceBase.getId());
        assertEquals(deviceBase, readDeviceBase);
    }

}