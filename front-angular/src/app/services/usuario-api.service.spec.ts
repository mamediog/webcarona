import { TestBed } from '@angular/core/testing';

import { UsuarioApiService } from './usuario-api.service';

describe('UsuarioApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsuarioApiService = TestBed.get(UsuarioApiService);
    expect(service).toBeTruthy();
  });
});
