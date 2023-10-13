package com.thaleskevin.developer_test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
        private Integer id;
        @JsonProperty("employee_name")
        private String employeeName;
        @JsonProperty("employee_salary")
        private Double employeeSalary;
        @JsonProperty("employee_age")
        private Integer employeeAge;
        @JsonProperty("profile_image")
        private String profileImage;
        @JsonProperty("employee_annual_salary")
        private Double employeeAnnualSalary;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getEmployeeName() {
                return employeeName;
        }

        public void setEmployeeName(String employeeName) {
                this.employeeName = employeeName;
        }

        public Double getEmployeeSalary() {
                return employeeSalary;
        }

        public void setEmployeeSalary(Double employeeSalary) {
                this.employeeSalary = employeeSalary;
        }

        public Integer getEmployeeAge() {
                return employeeAge;
        }

        public void setEmployeeAge(Integer employeeAge) {
                this.employeeAge = employeeAge;
        }

        public String getProfileImage() {
                return profileImage;
        }

        public void setProfileImage(String profileImage) {
                this.profileImage = profileImage;
        }

        public Double getEmployeeAnnualSalary() {
                return employeeAnnualSalary;
        }

        public void setEmployeeAnnualSalary(Double employeeAnnualSalary) {
                this.employeeAnnualSalary = employeeAnnualSalary;
        }
}
