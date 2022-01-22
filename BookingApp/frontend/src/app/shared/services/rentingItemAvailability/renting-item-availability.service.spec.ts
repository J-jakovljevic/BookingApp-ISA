import { TestBed } from '@angular/core/testing';

import { RentingItemAvailabilityService } from './renting-item-availability.service';

describe('RentingItemAvailabilityService', () => {
  let service: RentingItemAvailabilityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RentingItemAvailabilityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
