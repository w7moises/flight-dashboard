import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardPasajeroComponent } from './dashboard.pasajero.component';

describe('DashboardPasajeroComponent', () => {
  let component: DashboardPasajeroComponent;
  let fixture: ComponentFixture<DashboardPasajeroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardPasajeroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardPasajeroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
