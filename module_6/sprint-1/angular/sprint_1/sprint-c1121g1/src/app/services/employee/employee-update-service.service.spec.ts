import { TestBed } from '@angular/core/testing';

import { EmployeeUpdateServiceService } from './employee-update-service.service';

describe('EmployeeUpdateServiceService', () => {
  let service: EmployeeUpdateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeUpdateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
