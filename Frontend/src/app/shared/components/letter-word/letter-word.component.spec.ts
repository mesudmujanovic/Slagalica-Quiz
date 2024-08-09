import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LetterWordComponent } from './letter-word.component';

describe('LetterWordComponent', () => {
  let component: LetterWordComponent;
  let fixture: ComponentFixture<LetterWordComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LetterWordComponent]
    });
    fixture = TestBed.createComponent(LetterWordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
