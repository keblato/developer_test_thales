package com.thaleskevin.developer_test.service;

import com.thaleskevin.developer_test.model.Employee;
import com.thaleskevin.developer_test.repository.EmployeeRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService = new EmployeeService();


    @DisplayName("testGetEmployeesSuccessful")
    @Test
    void testGetListEmployeeSuccessful() {

        Employee employee = new Employee(2, "Doe", 20, "", 1, 12);
        Employee[] employeeList = new Employee[1];
        employeeList[0] = employee;
        when(employeeRepository.findAll()).thenReturn(employeeList);

        Employee[] res = employeeService.getEmployees();
        assertEquals(1, res.length);
        Assert.noNullElements(res, "array of Employee mustn't contain null elements");
        assertEquals("Doe", res[0].getEmployeeName());
        assertEquals(12, res[0].getEmployeeSalary() * 12);

    }
    @DisplayName("testGetEmployeesTooManyRequest")
    @Test
    void testGetListEmployeeTooManyRequest() {
        when(employeeRepository.findAll()).thenThrow(new HttpClientErrorException(HttpStatus.TOO_MANY_REQUESTS));
        assertThrows(HttpClientErrorException.class, () -> employeeRepository.findAll());
        assertThatThrownBy(() -> employeeRepository.findAll()).hasMessage(HttpStatus.TOO_MANY_REQUESTS.toString());

    }

    @DisplayName("testGetEmployeesTooManyRequest")
    @Test
    void testGetEmployeeSuccessful() {

        Employee employee = new Employee(2, "Doe", 20, "", 2, 24);

        when(employeeRepository.findOne("2")).thenReturn(employee);

        Employee res = employeeService.getEmployeeById("2");

        assertEquals(2, res.getId() );
        assertEquals("Doe", res.getEmployeeName());
        assertEquals(24, res.getEmployeeSalary() * 12);
        assertEquals(20, res.getEmployeeAge() );
        assertEquals(2, res.getEmployeeSalary() );

    }

    @DisplayName("testGetEmployeesTooManyRequest")
    @Test
    void testGetEmployeeTooManyRequest() {
        when(employeeRepository.findOne("2")).thenThrow(new HttpClientErrorException(HttpStatus.TOO_MANY_REQUESTS));
        assertThrows(HttpClientErrorException.class, () -> employeeRepository.findOne("2"));
        assertThatThrownBy(() -> employeeRepository.findOne("2")).hasMessage(HttpStatus.TOO_MANY_REQUESTS.toString());

    }
}
