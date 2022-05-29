import { TestBed } from '@angular/core/testing';

import { CustomerChooseServiceService } from './customer-choose-service.service';

describe('CustomerChooseServiceService', () => {
  let service: CustomerChooseServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerChooseServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
