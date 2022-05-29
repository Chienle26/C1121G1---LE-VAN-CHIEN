import { TestBed } from '@angular/core/testing';

import { ProductUpdateServiceService } from './product-update-service.service';

describe('ProductUpdateServiceService', () => {
  let service: ProductUpdateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductUpdateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
