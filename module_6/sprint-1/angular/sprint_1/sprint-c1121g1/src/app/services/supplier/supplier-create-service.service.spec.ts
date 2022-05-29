import { TestBed } from '@angular/core/testing';

import { SupplierCreateServiceService } from './supplier-create-service.service';

describe('SupplierCreateServiceService', () => {
  let service: SupplierCreateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupplierCreateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
