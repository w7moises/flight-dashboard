import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardAgentesComponent } from './dashboard.agentes.component';

describe('DashboardAgentesComponent', () => {
  let component: DashboardAgentesComponent;
  let fixture: ComponentFixture<DashboardAgentesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardAgentesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardAgentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
