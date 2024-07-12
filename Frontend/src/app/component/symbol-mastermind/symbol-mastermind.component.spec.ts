import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SymbolMastermindComponent } from './symbol-mastermind.component';

describe('SymbolMastermindComponent', () => {
  let component: SymbolMastermindComponent;
  let fixture: ComponentFixture<SymbolMastermindComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SymbolMastermindComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SymbolMastermindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
