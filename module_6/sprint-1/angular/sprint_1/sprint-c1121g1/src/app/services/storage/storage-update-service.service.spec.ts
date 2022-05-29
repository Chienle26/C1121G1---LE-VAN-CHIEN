import { TestBed } from '@angular/core/testing';

import { StorageUpdateServiceService } from './storage-update-service.service';

describe('StorageUpdateServiceService', () => {
  let service: StorageUpdateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StorageUpdateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
