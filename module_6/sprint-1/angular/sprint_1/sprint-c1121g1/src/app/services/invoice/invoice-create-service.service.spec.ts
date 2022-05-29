import { TestBed } from '@angular/core/testing';

import { InvoiceCreateServiceService } from './invoice-create-service.service';

describe('InvoiceCreateServiceService', () => {
  let service: InvoiceCreateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InvoiceCreateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
