package com.myworkspace.reportapp.service.dto.mapper;

import com.myworkspace.reportapp.entity.customer.Employee;
import com.myworkspace.reportapp.service.dto.employee.EmployeeView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    EmployeeView employeeEntityToView(Employee employee);


}
