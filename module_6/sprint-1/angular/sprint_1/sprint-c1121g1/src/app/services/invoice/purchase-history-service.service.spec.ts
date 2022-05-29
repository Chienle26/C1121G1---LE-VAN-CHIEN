import { TestBed } from '@angular/core/testing';

import { PurchaseHistoryServiceService } from './purchase-history-service.service';

describe('PurchaseHistoryServiceService', () => {
  let service: PurchaseHistoryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PurchaseHistoryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
