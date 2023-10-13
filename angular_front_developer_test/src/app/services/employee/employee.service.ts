import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Employee } from 'src/app/models';
import { LoaderService } from '../loader';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  constructor(private http: HttpClient, private loaderService: LoaderService) {}

  private _employees = new Subject<Employee[]>();
  fetchEmployees() {
    this.loaderService.setLoading(true);
    this.http
      .get<Employee[]>(environment.apiUrl)
      .pipe()
      .subscribe((employees: Employee[]) => {
        this._employees.next(employees);
        this.loaderService.setLoading(false);
      });
  }
  fetchOneEmployee(id: String) {
    this.loaderService.setLoading(true);

    this.http
      .get<Employee>(environment.apiUrl + '/' + id)
      .subscribe((employee: Employee) => {
        this._employees.next([employee]);
        this.loaderService.setLoading(false);
      });
  }

  get employees(): Observable<Employee[]> {
    return this._employees;
  }
}
