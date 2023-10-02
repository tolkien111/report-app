package com.myworkspace.reportapp.controller;

import com.myworkspace.reportapp.service.UserService;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import com.myworkspace.reportapp.service.dto.sorting.EmployeeAndManagerSortColumn;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/employees") // Dodatkowo DB connection
    public ResponseEntity<Page<EmployeeView>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "LAST_NAME") EmployeeAndManagerSortColumn sortBy, //utworzyć @ExceptionHandler
            @RequestParam(defaultValue = "ASC") Direction direction
    ) {
        return ResponseEntity.ok(userService.getAllEmployees(PageRequest.of(page, size, direction, sortBy.getColumnName())));
    }
}
