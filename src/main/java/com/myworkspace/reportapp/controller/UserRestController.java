package com.myworkspace.reportapp.controller;

import com.myworkspace.reportapp.service.UserService;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

    @NonNull
    private UserService userService;


    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeView>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "lastName") String sortBy,
            @RequestParam(defaultValue = "ASC") Direction direction
    ) {
        Pageable pageable = PageRequest.of(page, size, direction, sortBy);
        List<EmployeeView> employees = userService.getAllEmployees(pageable);
        return ResponseEntity.ok(employees);
    }
}
