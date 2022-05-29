import { TestBed } from '@angular/core/testing';

import { CustomerListServiceService } from './customer-list-service.service';

describe('CustomerListServiceService', () => {
  let service: CustomerListServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerListServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
