package com.myworkspace.reportapp.service;

import com.myworkspace.reportapp.entity.customer.Customer;
import com.myworkspace.reportapp.entity.customer.Employee;
import com.myworkspace.reportapp.entity.customer.Manager;
import com.myworkspace.reportapp.repository.UserRepository;
import com.myworkspace.reportapp.service.dto.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Test
    void shouldFindOnlyEmployeesFromDb(){
        //GIVEN
        final var employee1 = new Employee("email1@gmail.com", "658481236", "Jane", "Odonel", "admin123");
        final var employee2 = new Employee("email2@gmail.com", "123145698", "Jack", "Sparow", "pass456");
        final var manager1 = new Manager("email3@gmail.com", "669988554", "Jonny", "Bravo", "pass456");
        final var customer1 = new Customer("email4@gmail.com", "998877665", "Jack", "Bolton Street 10, London");

        userRepository.saveAllAndFlush(List.of(employee1,employee2,manager1,customer1));

        //WHEN
        final var readOnlyEmployeeList = userService.getAllEmployees();

        //THEN
        assertEquals(2, readOnlyEmployeeList.size());
        assertEquals(userMapper.employeeEntityToView(employee1), readOnlyEmployeeList.get(0));
        assertEquals(userMapper.employeeEntityToView(employee2), readOnlyEmployeeList.get(1));
    }



}