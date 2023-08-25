package com.myworkspace.reportapp.service;

import com.myworkspace.reportapp.repository.UserRepository;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import com.myworkspace.reportapp.service.dto.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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


    public List<EmployeeView> getAllEmployees(Pageable pageable) {
        return userRepository.findAllEmployees(pageable)
                .stream()
                .map(mapper::employeeEntityToView)
                .collect(Collectors.toList());

    }
}
