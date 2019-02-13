import { TestBed } from '@angular/core/testing';

import { CaronaApiService } from './carona-api.service';

describe('CaronaApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CaronaApiService = TestBed.get(CaronaApiService);
    expect(service).toBeTruthy();
  });
});
