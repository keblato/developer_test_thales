package com.thaleskevin.developer_test.repository;

import com.thaleskevin.developer_test.config.RepositoryConfig;
import com.thaleskevin.developer_test.model.Employee;
import com.thaleskevin.developer_test.model.EmployeeRequest;
import com.thaleskevin.developer_test.model.ListEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;

@Repository
public class EmployeeRepository implements BaseRepository<Employee, String> {
    final private RestTemplate template = new RestTemplate();


    @Autowired
    private RepositoryConfig repositoryConfig;

    @Override
    public Employee findOne(String id) {
        try {
            String url = repositoryConfig.getApi() + "/employee/" + id;
            EmployeeRequest employeeRequest = template.getForObject(url, EmployeeRequest.class);
            if (employeeRequest != null && employeeRequest.getData() != null) {
                return employeeRequest.getData();
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }catch (HttpClientErrorException.TooManyRequests e) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS);
        }

    }

    @Override
    public Employee[] findAll() {
        try {
            String url =repositoryConfig.getApi() + "employees";

            ListEmployeeRequest listEmployeeRequest = template.getForObject(url, ListEmployeeRequest.class);
            if (listEmployeeRequest != null) {
                return listEmployeeRequest.getData();
            }
            return new Employee[0];
        } catch (HttpClientErrorException.TooManyRequests e) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS);
        }

    }
}
