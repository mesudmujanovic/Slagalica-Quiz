import { Injectable } from '@angular/core';
import { MyNumber } from '../interface/MyNumber-Interface';
import { MyNumberService } from './my-number.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberStateService {

  public number1: number | undefined;
  public number2: number | undefined;
  public number3: number | undefined;
  public number4: number | undefined;
  public number5: number | undefined;
  public number6: number | undefined;
  public result: number | undefined;
  allNumber$: Observable<MyNumber[]> = this.myNumberService.getAllNumber();

  constructor(private myNumberService: MyNumberService) {}

  fetchNumbers() {
    this.allNumber$.subscribe(
      numbers => {
        if (numbers.length > 0) {
          const randIndex = Math.floor(Math.random() * numbers.length);
          const { number1, number2, number3, number4, number5, number6, result } = numbers[randIndex];
          this.number1 = number1;
          this.number2 = number2;
          this.number3 = number3;
          this.number4 = number4;
          this.number5 = number5;
          this.number6 = number6;
          this.result = result;
        }
      },
      error => {
        console.error("Error fetching numbers", error);
      }
    );
  };

  getNumbers(): (number | undefined)[] {
    return [this.number1, this.number2, this.number3, this.number4, this.number5, this.number6, this.result];
  }

}