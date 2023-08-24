package com.myworkspace.reportapp.controller;

import com.myworkspace.reportapp.service.UserService;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

    @NonNull
    private UserService userService;


    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeView>> getAllEmployees(){
        List<EmployeeView> employees = userService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
