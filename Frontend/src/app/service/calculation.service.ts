import { Injectable } from '@angular/core';
import { catchError, from, map, of, reduce } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalculationService {
  private currValue: string = '0';
  public toShow: string = '0'; 

  equals( num1: number | undefined, num2: number | undefined, num3: number | undefined, 
    num4: number | undefined, num5: number | undefined, num6: number | undefined, result: number | undefined) {
      
    const allNumbers = [
      num1,
      num2,
      num3,
      num4,
      num5,
      num6
    ].map(num => num?.toString());

    const numbersInShow = this.toShow.match(/\d+/g) || [];
    const numbersObservable = from(numbersInShow).pipe(
      map(num => parseInt(num)),
      reduce((acc, curr) => acc + curr, 0),
      catchError(err => {
        console.error(err);
        return of(NaN); 
      })
    );

    if(numbersInShow) {
      numbersObservable.subscribe(
        sum => {
          if (numbersInShow.every(everyNumber => allNumbers.includes(everyNumber))) {
            if (result === sum) {
              alert("Čestitamo! Pogodili ste tačan broj!");
            } else {
              alert("Rezultat se ne poklapa sa unetim izrazom, pokušajte ponovo.");
            }
          } else {
            alert("Uneti brojevi se ne nalaze u izrazu.");
          }
        },
        err => {
          console.error(err);
          alert(`Došlo je do greške: ${err.message}`);
        }
      );
    } 
  }
  
  writeToInput(value: string) {
    this.currValue = this.currValue + value;
    this.toShow = this.currValue;    
  }

  clear() {
    this.toShow = '0';
  }

  back() {
    this.currValue = this.currValue.slice(0, -1);
    this.toShow = this.currValue;
  }
}
