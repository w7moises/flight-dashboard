import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAereopuertoComponent } from './create.aereopuerto.component';

describe('CreateAereopuertoComponent', () => {
  let component: CreateAereopuertoComponent;
  let fixture: ComponentFixture<CreateAereopuertoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAereopuertoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateAereopuertoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
