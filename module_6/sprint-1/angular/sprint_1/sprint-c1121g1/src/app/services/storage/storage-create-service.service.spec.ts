import { TestBed } from '@angular/core/testing';

import { StorageCreateServiceService } from './storage-create-service.service';

describe('StorageCreateServiceService', () => {
  let service: StorageCreateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StorageCreateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
