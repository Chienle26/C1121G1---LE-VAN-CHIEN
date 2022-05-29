import { TestBed } from '@angular/core/testing';

import { CustomerReportServiceService } from './customer-report-service.service';

describe('CustomerReportServiceService', () => {
  let service: CustomerReportServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerReportServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
