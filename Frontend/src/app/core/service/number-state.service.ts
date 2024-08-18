import { Injectable, OnDestroy } from '@angular/core';
import { MyNumber } from '../interface/MyNumber-Interface';
import { MyNumberService } from './my-number.service';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { LetterWordService } from './letter-word.service';

@Injectable({
  providedIn: 'root'
})
export class NumberStateService implements OnDestroy {

  private destroy$: Subject<void> = new Subject<void>();
  public numbers: MyNumber | undefined;
  public letters: string[] = [];
  allNumber$: Observable<MyNumber[]> = this.myNumberService.getAllNumber();
  private resultSubject: BehaviorSubject<number | undefined> = new BehaviorSubject<number | undefined>(undefined);
  result$: Observable<number | undefined> = this.resultSubject.asObservable();

  constructor(private myNumberService: MyNumberService, private letterService: LetterWordService) {
    this.fetchNumbers();
    this.getLetter()
  }

  getLetter(): string[] {
    this.letterService.getRandomLetterWord().subscribe(a => {
      if (a.letters) {
        this.letters = a.letters;
      }
    });
    return this.letters
  }

  fetchNumbers() {
    this.allNumber$.pipe(
      takeUntil(this.destroy$)
    ).subscribe(
      numbers => {
        if (numbers.length > 0) {
          const randIndex = Math.floor(Math.random() * numbers.length);
          this.numbers = numbers[randIndex];
          this.resultSubject.next(this.numbers.result);
        }
      },
      error => {
        console.error("Error fetching numbers", error);
      }
    );
  }

  getNumbers(): (number | undefined)[] {
    return [this.numbers?.number1, this.numbers?.number2, this.numbers?.number3, this.numbers?.number4, this.numbers?.number5, this.numbers?.number6, this.numbers?.result];
  }

  getResult(): Observable<number | undefined> {
    return this.result$;
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
