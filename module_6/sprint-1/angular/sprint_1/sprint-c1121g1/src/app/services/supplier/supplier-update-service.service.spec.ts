import { TestBed } from '@angular/core/testing';

import { SupplierUpdateServiceService } from './supplier-update-service.service';

describe('SupplierUpdateServiceService', () => {
  let service: SupplierUpdateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupplierUpdateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
