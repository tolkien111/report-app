package com.myworkspace.reportapp.service;

import com.myworkspace.reportapp.entity.customer.Employee;
import com.myworkspace.reportapp.entity.customer.enums.UserType;
import com.myworkspace.reportapp.repository.UserRepository;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import com.myworkspace.reportapp.service.dto.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    @NonNull
    private final UserRepository userRepository;

    @NonNull
    private final UserMapper mapper;

    public Page<EmployeeView> getAllEmployees(Pageable pageable) {
        return userRepository.findAllRelevantUsers(UserType.EMPLOYEE,pageable)
                .map(user -> (Employee) user)
                .map(mapper::employeeEntityToView);

    }
}
