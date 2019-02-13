import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaronaListIdComponent } from './carona-list-id.component';

describe('CaronaListIdComponent', () => {
  let component: CaronaListIdComponent;
  let fixture: ComponentFixture<CaronaListIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaronaListIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaronaListIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
