import { TestBed } from '@angular/core/testing';

import { QrcodeCreateServiceService } from './qrcode-create-service.service';

describe('QrcodeCreateServiceService', () => {
  let service: QrcodeCreateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QrcodeCreateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
