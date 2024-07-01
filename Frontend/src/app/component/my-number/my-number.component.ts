import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MyNumberService } from 'src/app/service/my-number.service';
import { Observable, catchError, of } from 'rxjs';
import { MyNumber } from 'src/app/interface/MyNumber-Interface';
import { ScoreService } from 'src/app/service/score.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-number',
  templateUrl: './my-number.component.html',
  styleUrls: ['./my-number.component.css']
})
export class MyNumberComponent {

  allNumber$: Observable<MyNumber[]> = this.myNumberService.getAllNumber();
  num1: number | undefined;
  num2: number | undefined;
  num3: number | undefined;
  num4: number | undefined;
  num5: number | undefined;
  num6: number | undefined;
  currentDivIndex: number = 1;
  result: number | undefined;
  public counter: number = 60
  public toShow: any;
  public currValue: string = '';
  public counterButton: number = 0;

  constructor(private http: HttpClient,
    private myNumberService: MyNumberService,
    private scoreService: ScoreService,
    private router: Router) { }

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

  equals() {
    const allNumbers = [
      this.num1.toString(),
      this.num2.toString(),
      this.num3.toString(),
      this.num4.toString(),
      this.num5.toString(),
      this.num6.toString()
    ];

    const enteredNumbers = this.toShow.match(/\d+/g);
    if (
      enteredNumbers.every((everyNumber) => {
        return allNumbers.includes(everyNumber);
      })
    ) {
      try {
        this.toShow = eval(this.toShow);
        alert("Čestitamo! Pogodili ste tačan broj!");
        this.scoreService.addToScore(15);
        this.router.navigate(['/association']);
      } catch (err) {
        console.log(err);
      }
    } else {
      alert(
        "Žao nam je, niste pobedili!! Broj koji ste uneli ne pripada grupi vaših izabranih brojeva, pokušajte ponovo"
      );
      this.router.navigate(['/user']);
    }
  }

  writeToInput(value: string) {
    this.currValue = this.currValue + value;
    this.toShow = this.currValue;
  }

  clear() {
    this.toShow = '0'
  }

  back() {
    this.currValue = this.currValue.slice(0, -1);
    this.toShow = this.currValue;
  }

}
