import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardAereopuertosComponent } from './dashboard.aereopuertos.component';

describe('DashboardAereopuertosComponent', () => {
  let component: DashboardAereopuertosComponent;
  let fixture: ComponentFixture<DashboardAereopuertosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardAereopuertosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardAereopuertosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
