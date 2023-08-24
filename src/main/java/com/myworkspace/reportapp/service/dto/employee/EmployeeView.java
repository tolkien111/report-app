package com.myworkspace.reportapp.service.dto.employee;

import lombok.Data;

@Data
public class EmployeeView {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean activeUser;
}
