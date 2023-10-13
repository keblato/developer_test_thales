import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpStatusCode,
} from '@angular/common/http';
import { Observable, Subject, catchError, throwError } from 'rxjs';
import { Employee } from 'src/app/models';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  constructor(private http: HttpClient) {}
  private _employeeUrl = 'http://localhost:8080/employee';

  private _employees = new Subject<Employee[]>();
  fetchEmployees() {
    this.http
      .get<Employee[]>(this._employeeUrl)
      .subscribe((employees: Employee[]) => {
        this._employees.next(employees);
      });
  }
  fetchOneEmployee(id: String) {
    this.http
      .get<Employee>(this._employeeUrl + '/' + id)
      .subscribe((employee: Employee) => {
        this._employees.next([employee]);
      });
  }

  get employees(): Observable<Employee[]> {
    return this._employees;
  }
}
