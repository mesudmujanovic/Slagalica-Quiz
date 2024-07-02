import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkockoComponent } from './skocko.component';

describe('SkockoComponent', () => {
  let component: SkockoComponent;
  let fixture: ComponentFixture<SkockoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SkockoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SkockoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
