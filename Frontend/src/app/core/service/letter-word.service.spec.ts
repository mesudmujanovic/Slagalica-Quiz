import { TestBed } from '@angular/core/testing';

import { LetterWordService } from './letter-word.service';

describe('LetterWordService', () => {
  let service: LetterWordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LetterWordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
