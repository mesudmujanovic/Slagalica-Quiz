import { Component } from '@angular/core';
import { CalculationService } from '../service/calculation.service';
import { MyNumberService } from '../service/my-number.service';
import { Observable } from 'rxjs';
import { MyNumber } from '../interface/MyNumber-Interface';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  allNumber$: Observable<MyNumber[]> = this.myNumberService.getAllNumber();
  public num1: number | undefined;
  public num2: number | undefined;
  public num3: number | undefined;
  public num4: number | undefined;
  public num5: number | undefined;
  public num6: number | undefined
  public result: number | undefined;

  constructor(public calculationService: CalculationService,
    private myNumberService: MyNumberService){}

  equals() {    
    this.calculationService.equals(this.num1, this.num2, this.num3, this.num4, this.num5, this.num6, this.result);
  }

  writeToInput(value: string) {
    this.calculationService.writeToInput(value);
  }

  clear() {
    this.calculationService.clear();
  }

  back() {
    this.calculationService.back();
  }
 
  ngOnInit() {
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
  }
}
