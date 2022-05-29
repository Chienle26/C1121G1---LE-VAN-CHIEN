import { TestBed } from '@angular/core/testing';

import { StorageListServiceService } from './storage-list-service.service';

describe('StorageListServiceService', () => {
  let service: StorageListServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StorageListServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
