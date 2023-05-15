import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardVuelosComponent } from './dashboard.vuelos.component';

describe('DashboardVuelosComponent', () => {
  let component: DashboardVuelosComponent;
  let fixture: ComponentFixture<DashboardVuelosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardVuelosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardVuelosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
