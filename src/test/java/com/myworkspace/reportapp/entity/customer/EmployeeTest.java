package com.myworkspace.reportapp.entity.customer;

import com.myworkspace.reportapp.entity.EntityTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest extends EntityTest {
    @Test
    void shouldSaveEmployee(){
        //GIVEN
        final var employee = new Employee("yahoo@wp.pl",
                "669876222",
                "Alan",
                "James",
                "bbb");

        //WHEN
        persistObject(employee);

        //THEN
        final var readEmployee = em.find(Employee.class, employee.getId());
        assertEquals(employee, readEmployee);
    }

}