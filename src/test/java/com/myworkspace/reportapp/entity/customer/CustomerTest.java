package com.myworkspace.reportapp.entity.customer;

import com.myworkspace.reportapp.entity.EntityTest;
import com.myworkspace.reportapp.entity.TestDataFactory;
import com.myworkspace.reportapp.entity.device.Device;
import com.myworkspace.reportapp.entity.device.DeviceBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest extends EntityTest {

    //wstrzyknij obiekt JPARepository w tym przypadku CustomerRepository

    @Test
    void shouldSaveCustomer() {
        //GIVEN
        final var customer = TestDataFactory.createSampleCustomer();
        //WHEN
        persistObject(customer);
        //THEN
        final var readCustomer = em.find(Customer.class, customer.getId());
        assertEquals(customer, readCustomer);

    }

    @Test
    void shouldSaveCustomerWithDevice() {
        //GIVEN
        final var customer = TestDataFactory.createSampleCustomer();
        final var deviceBase = new DeviceBase("ScanBox 6130", "1ASD230421", 3);
        final var device = new Device("20230102665577", deviceBase);

        //WHEN
        persistObject(customer);
        customer.addDevice(device);
        em.merge(customer);
        em.flush();
        em.clear();

        //THEN
        final var readCustomer = em.find(Customer.class, customer.getId());
        assertEquals(device, readCustomer.getDeviceList().get(0));
    }

}