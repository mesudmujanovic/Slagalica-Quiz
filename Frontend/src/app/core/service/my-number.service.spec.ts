import { TestBed } from '@angular/core/testing';

import { MyNumberService } from './my-number.service';

describe('MyNumberService', () => {
  let service: MyNumberService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyNumberService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
