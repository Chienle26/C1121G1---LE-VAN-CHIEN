import { TestBed } from '@angular/core/testing';

import { ProductCreateServiceService } from './product-create-service.service';

describe('ProductCreateServiceService', () => {
  let service: ProductCreateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductCreateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
