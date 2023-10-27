import { TestBed } from '@angular/core/testing';

import { TrackerServicesService } from './tracker-services.service';

describe('TrackerServicesService', () => {
  let service: TrackerServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrackerServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
