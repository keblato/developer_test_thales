import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesSearchFormComponent } from './employees-search-form.component';

describe('EmployeesSearchFormComponent', () => {
  let component: EmployeesSearchFormComponent;
  let fixture: ComponentFixture<EmployeesSearchFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmployeesSearchFormComponent]
    });
    fixture = TestBed.createComponent(EmployeesSearchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
