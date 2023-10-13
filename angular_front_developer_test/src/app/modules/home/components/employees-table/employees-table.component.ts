import { Component } from '@angular/core';
import { Employee } from 'src/app/models';
import { MatTableDataSource } from '@angular/material/table';
import { EmployeeService } from 'src/app/services';

@Component({
  selector: 'app-employees-table',
  templateUrl: './employees-table.component.html',
  styleUrls: ['./employees-table.component.scss'],
})
export class EmployeesTableComponent {
  constructor(private employeeService: EmployeeService) {
    this.employees = [];
    this.dataSource = new MatTableDataSource(this.employees);
  }
  displayedColumns: string[] = [
    'id',
    'employee_name',
    'employee_salary',
    'employee_annual_salary',
    'employee_age',
    'profile_image',
  ];
  employees: Employee[];
  dataSource: MatTableDataSource<Employee>;

  ngOnInit(): void {
    this.getEmployees();
  }
  getEmployees(): void {
    this.employeeService.employees.subscribe((employees: Employee[]) => {
      this.employees = employees;
      this.dataSource = new MatTableDataSource(this.employees);
    });
  }
}
