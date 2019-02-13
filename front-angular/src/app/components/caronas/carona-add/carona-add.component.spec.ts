import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaronaAddComponent } from './carona-add.component';

describe('CaronaAddComponent', () => {
  let component: CaronaAddComponent;
  let fixture: ComponentFixture<CaronaAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaronaAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaronaAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
