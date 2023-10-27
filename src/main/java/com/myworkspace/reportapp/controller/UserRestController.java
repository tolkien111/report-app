package com.myworkspace.reportapp.controller;

import com.myworkspace.reportapp.config.pageable.PageProperties;
import com.myworkspace.reportapp.service.UserService;
import com.myworkspace.reportapp.service.dto.employee.EmployeeForm;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import com.myworkspace.reportapp.service.dto.sorting.EmployeeAndManagerSortColumn;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final PageProperties pageProperties;

    @GetMapping("/employees") // Dodatkowo DB connection
    public ResponseEntity<Page<EmployeeView>> getAllEmployees(
            @RequestParam(defaultValue = "#{pageProperties.defaultPage}") int page,
            @RequestParam(defaultValue = "#{pageProperties.defaultSize}") int size,
            @RequestParam(defaultValue = "#{pageProperties.defaultSortBy}") EmployeeAndManagerSortColumn sortBy, //utworzyć @ExceptionHandler
            @RequestParam(defaultValue = "#{pageProperties.defaultDirection}") Direction direction
    ) {
        return ResponseEntity.ok(userService.getAllEmployees(PageRequest.of(page, size, direction, sortBy.getColumnName())));
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeView> createEmployee (@RequestBody EmployeeForm form){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createEmployee(form));
    }
}
