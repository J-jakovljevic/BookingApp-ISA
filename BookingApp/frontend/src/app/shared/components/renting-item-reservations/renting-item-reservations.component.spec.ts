import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentingItemReservationsComponent } from './renting-item-reservations.component';

describe('RentingItemReservationsComponent', () => {
  let component: RentingItemReservationsComponent;
  let fixture: ComponentFixture<RentingItemReservationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RentingItemReservationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RentingItemReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
