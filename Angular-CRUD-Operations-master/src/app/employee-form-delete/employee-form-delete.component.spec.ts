import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeFormDeleteComponent } from './employee-form-delete.component';

describe('EmployeeFormDeleteComponent', () => {
  let component: EmployeeFormDeleteComponent;
  let fixture: ComponentFixture<EmployeeFormDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeFormDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeFormDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
