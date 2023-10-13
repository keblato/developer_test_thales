import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { NgForm } from '@angular/forms';
import { DialogModule } from '@angular/cdk/dialog';

import { EmployeeService } from 'src/app/services';
import { MatButtonModule } from '@angular/material/button';
import { DialogComponent } from '../dialog-component';

@Component({
  standalone: true,
  selector: 'app-employees-search-form',
  templateUrl: './employees-search-form.component.html',
  styleUrls: ['./employees-search-form.component.scss'],
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    DialogModule,
    DialogComponent,
    MatButtonModule,
  ],
})
export class EmployeesSearchFormComponent {
  constructor(private employeeService: EmployeeService) {}
  onSubmit(f: NgForm) {
    if (f.valid) {
      if (f.value.employeeId === '') {
        this.employeeService.fetchEmployees();
      } else {
        this.employeeService.fetchOneEmployee(f.value.employeeId);
      }
    }
  }
}
