import { TestBed } from '@angular/core/testing';

import { RentingItemsService } from './renting-items.service';

describe('RentingItemsService', () => {
  let service: RentingItemsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RentingItemsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
