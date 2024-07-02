import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MyNumberService } from 'src/app/service/my-number.service';
import { Observable} from 'rxjs';
import { MyNumber } from 'src/app/interface/MyNumber-Interface';
import { ScoreService } from 'src/app/service/score.service';
import { Router } from '@angular/router';
import { CalculationService } from 'src/app/service/calculation.service';

@Component({
  selector: 'app-my-number',
  templateUrl: './my-number.component.html',
  styleUrls: ['./my-number.component.css']
})
export class MyNumberComponent {
  public result: number | undefined;
  allNumber$: Observable<MyNumber[]> = this.myNumberService.getAllNumber();
  public num1: number | undefined;
  public num2: number | undefined;
  public num3: number | undefined;
  public num4: number | undefined;
  public num5: number | undefined;
  public num6: number | undefined
  currentDivIndex: number = 1;
  public counter: number = 60
  public toShow: any;
  public currValue: string = '';
  public counterButton: number = 0;
  numbers: (number | undefined)[] = [undefined, undefined, undefined, undefined, undefined, undefined];

  constructor(private myNumberService: MyNumberService,
             public calculationService: CalculationService) { }

    addNumToDivs() {
      const currentNum = this['num' + this.currentDivIndex];
      const currentDiv = document.getElementById('num' + this.currentDivIndex);

      if (currentDiv) {
        if (currentDiv.classList.contains('numSpin')) {
          currentDiv.textContent = currentNum?.toString() ?? '';
          currentDiv.classList.remove('numSpin');
          this.currentDivIndex++;
          const nextDiv = document.getElementById('num' + this.currentDivIndex);
          if (nextDiv) {
            nextDiv.classList.add('numSpin');
          }
            this.counterButton++;
          
          if (this.counterButton === 6) {
            const calcDiv = document.getElementsByClassName('containerCalc')[0] as HTMLElement;
            calcDiv.classList.remove('hide');
          }
        } else {
          currentDiv.classList.add('numSpin');
        }
      }
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
  // equals() {    
  //   this.calculationService.equals(this.num1, this.num2, this.num3, this.num4, this.num5, this.num6, this.result);
  // }

  // writeToInput(value: string) {
  //   this.calculationService.writeToInput(value);
  // }

  // clear() {
  //   this.calculationService.clear();
  // }

  // back() {
  //   this.calculationService.back();
  // }
 
}
