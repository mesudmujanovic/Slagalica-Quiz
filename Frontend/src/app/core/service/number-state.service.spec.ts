import { TestBed } from '@angular/core/testing';

import { NumberStateService } from './number-state.service';

describe('NumberStateService', () => {
  let service: NumberStateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NumberStateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
