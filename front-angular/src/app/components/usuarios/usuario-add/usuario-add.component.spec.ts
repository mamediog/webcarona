import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioAddComponent } from './usuario-add.component';

describe('UsuarioAddComponent', () => {
  let component: UsuarioAddComponent;
  let fixture: ComponentFixture<UsuarioAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsuarioAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsuarioAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
