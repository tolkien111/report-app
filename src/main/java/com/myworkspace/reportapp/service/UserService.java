package com.myworkspace.reportapp.service;

import com.myworkspace.reportapp.entity.customer.Employee;
import com.myworkspace.reportapp.repository.UserRepository;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import com.myworkspace.reportapp.service.dto.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    @NonNull
    private final UserRepository userRepository;

    @NonNull
    private final UserMapper mapper;


    public List<EmployeeView> getAllEmployees() {
        return userRepository.findAllUsersWhen("EMPLOYEE")
                .stream()
                .filter(user -> user instanceof Employee)
                .map(entity -> mapper.employeeEntityToView((Employee)entity))
                .collect(Collectors.toList());

    }
}
