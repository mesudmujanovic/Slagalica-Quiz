import { Injectable } from '@angular/core';
import { MyNumber } from '../interface/MyNumber-Interface';
import { MyNumberService } from './my-number.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberStateService {

  public numbers: MyNumber | undefined;

  allNumber$: Observable<MyNumber[]> = this.myNumberService.getAllNumber();

  constructor(private myNumberService: MyNumberService) {}


  fetchNumbers() {
    this.allNumber$.subscribe(
      numbers => {
        if (numbers.length > 0) {
          const randIndex = Math.floor(Math.random() * numbers.length);
          this.numbers = numbers[randIndex];
        }
      },
      error => {
        console.error("Error fetching numbers", error);
      }
    );
  }


  getNumbers(): (number | undefined)[] {
    return [this.numbers.number1, this.numbers.number2, this.numbers.number3, this.numbers.number4, this.numbers.number5, this.numbers.number6, this.numbers.result];
  }

}