import { TestBed } from '@angular/core/testing';

import { SymbolMastermindService } from './symbol-mastermind.service';

describe('SymbolMastermindService', () => {
  let service: SymbolMastermindService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SymbolMastermindService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
