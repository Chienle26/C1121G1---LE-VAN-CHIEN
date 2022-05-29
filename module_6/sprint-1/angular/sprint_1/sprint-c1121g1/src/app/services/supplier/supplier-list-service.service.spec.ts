import { TestBed } from '@angular/core/testing';

import { SupplierListServiceService } from './supplier-list-service.service';

describe('SupplierListServiceService', () => {
  let service: SupplierListServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupplierListServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
