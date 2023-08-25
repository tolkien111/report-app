package com.myworkspace.reportapp.repository;

import com.myworkspace.reportapp.entity.customer.Employee;
import com.myworkspace.reportapp.entity.customer.Manager;
import com.myworkspace.reportapp.entity.customer.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("FROM Employee e")
    Page<Employee> findAllEmployees(Pageable pageable);

    @Query("FROM Manager m")
    List<Manager> findAllManagers();
}
