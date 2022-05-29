import { TestBed } from '@angular/core/testing';

import { ProductListBestsellerServiceService } from './product-list-bestseller-service.service';

describe('ProductListBestsellerServiceService', () => {
  let service: ProductListBestsellerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductListBestsellerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
