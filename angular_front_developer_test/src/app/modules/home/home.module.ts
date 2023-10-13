import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { HomeRoutingModule } from './home-routing.module';
import { EmployeesTableComponent } from './components';
import { EmployeesSearchFormComponent } from 'src/app/components';
import { MatTableModule } from '@angular/material/table';

@NgModule({
  declarations: [HomeComponent, EmployeesTableComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    EmployeesSearchFormComponent,
    MatTableModule,
  ],
})
export class HomeModule {}
