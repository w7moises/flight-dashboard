import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateVueloComponent } from './create.vuelo.component';

describe('CreateVueloComponent', () => {
  let component: CreateVueloComponent;
  let fixture: ComponentFixture<CreateVueloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateVueloComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateVueloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
