import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerCottagesComponent } from './cottage-owner-cottages.component';

describe('CottageOwnerCottagesComponent', () => {
  let component: CottageOwnerCottagesComponent;
  let fixture: ComponentFixture<CottageOwnerCottagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerCottagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerCottagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
