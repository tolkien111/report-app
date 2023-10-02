package com.myworkspace.reportapp.service.dto.sorting;

public enum EmployeeAndManagerSortColumn {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    EMAIL("email"),
    PHONE_NUMBER("phoneNumber");

    private final String columnName;

    EmployeeAndManagerSortColumn(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
