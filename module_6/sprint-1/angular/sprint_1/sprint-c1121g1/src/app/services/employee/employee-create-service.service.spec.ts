import { TestBed } from '@angular/core/testing';

import { EmployeeCreateServiceService } from './employee-create-service.service';

describe('EmployeeCreateServiceService', () => {
  let service: EmployeeCreateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeCreateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
