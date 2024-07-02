import { Injectable } from '@angular/core';
import { MyNumber } from '../interface/MyNumber-Interface';
import { MyNumberService } from './my-number.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberStateService {

  public num1: number | undefined;
  public num2: number | undefined;
  public num3: number | undefined;
  public num4: number | undefined;
  public num5: number | undefined;
  public num6: number | undefined;
  public result: number | undefined;
  allNumber$: Observable<MyNumber[]> = this.myNumberService.getAllNumber();

  constructor(private myNumberService: MyNumberService) {}

  fetchNumbers() {
    this.allNumber$.subscribe(
      numbers => {
        if (numbers.length > 0) {
          const randIndex = Math.floor(Math.random() * numbers.length);
          const { number1, number2, number3, number4, number5, number6, result } = numbers[randIndex];
          this.num1 = number1;
          this.num2 = number2;
          this.num3 = number3;
          this.num4 = number4;
          this.num5 = number5;
          this.num6 = number6;
          this.result = result;
        }
      },
      error => {
        console.error("Error fetching numbers", error);
      }
    );
  };

  getNumbers(): (number | undefined)[] {
    return [this.num1, this.num2, this.num3, this.num4, this.num5, this.num6, this.result];
  }

}
