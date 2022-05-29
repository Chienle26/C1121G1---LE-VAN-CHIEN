import { TestBed } from '@angular/core/testing';

import { InvoiceHistoryServiceService } from './invoice-history-service.service';

describe('InvoiceHistoryServiceService', () => {
  let service: InvoiceHistoryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InvoiceHistoryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
