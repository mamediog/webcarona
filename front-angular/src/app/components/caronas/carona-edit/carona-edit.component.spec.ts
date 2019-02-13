import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaronaEditComponent } from './carona-edit.component';

describe('CaronaEditComponent', () => {
  let component: CaronaEditComponent;
  let fixture: ComponentFixture<CaronaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaronaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaronaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
