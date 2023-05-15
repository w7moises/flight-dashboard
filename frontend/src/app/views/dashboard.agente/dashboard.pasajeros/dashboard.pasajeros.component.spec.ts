import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardPasajerosComponent } from './dashboard.pasajeros.component';

describe('DashboardPasajerosComponent', () => {
  let component: DashboardPasajerosComponent;
  let fixture: ComponentFixture<DashboardPasajerosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardPasajerosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardPasajerosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
