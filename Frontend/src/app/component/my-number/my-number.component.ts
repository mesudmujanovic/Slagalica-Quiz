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

  constructor(private http: HttpClient,
    private myNumberService: MyNumberService,
    private scoreService: ScoreService,
    private router: Router,
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
          console.log("res",this.result);
          
        }
      },
      error => {
        console.error("Error fetching numbers", error);
      }
    );
    
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

  equals() {    
    this.calculationService.equals(this.num1, this.num2, this.num3, this.num4, this.num5, this.num6, this.result);
  }

  // equals() {
  //   const enteredNumbers = this.toShow.match(/\d+/g);
  //   const allNumbers = [
  //     this.num1, this.num2, this.num3, this.num4, this.num5, this.num6
  //   ].map(num => num?.toString() ?? '');
  
  //   if (enteredNumbers && enteredNumbers.every(everyNumber => allNumbers.includes(everyNumber))) {
  //     const sum = enteredNumbers.reduce((acc, curr) => acc + parseInt(curr), 0);
  
  //     try {
  //       const result = this.result;
  //       if (!isNaN(result) && result === sum) {
  //         alert("Čestitamo! Pogodili ste tačan broj!");
  //         this.scoreService.addToScore(15);
  //       } else {
  //         alert("Rezultat se ne poklapa sa unetim izrazom, pokušajte ponovo.");
  //       }
  //       this.toShow = sum.toString(); 
  //     } catch (err) {
  //       console.error(err);
  //       alert("Došlo je do greške prilikom izračunavanja izraza.");
  //     }
  //   } else {
  //     alert(
  //       "Žao nam je, niste uneli ispravan izraz. Molimo unesite validne brojeve i operatore."
  //     );
  //   }
  // }
  

  // writeToInput(value: string) {
  //   this.currValue = this.currValue + value;
  //   this.toShow = this.currValue;    
  // }

  // clear() {
  //   this.toShow = '0'
  // }

  // back() {
  //   this.currValue = this.currValue.slice(0, -1);
  //   this.toShow = this.currValue;
  // }

}
