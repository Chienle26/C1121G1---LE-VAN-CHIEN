import { TestBed } from '@angular/core/testing';

import { CustomerUpdateServiceService } from './customer-update-service.service';

describe('CustomerUpdateServiceService', () => {
  let service: CustomerUpdateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerUpdateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
