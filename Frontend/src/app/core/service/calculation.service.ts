import { Injectable } from '@angular/core';
import { catchError, from, map, of, reduce } from 'rxjs';
import { MyNumber } from '../interface/MyNumber-Interface';

@Injectable({
  providedIn: 'root'
})
export class CalculationService {
  public toShow: string = '0'; 

  equals( { number1, number2, number3, number4, number5, number6, result }: MyNumber) {

    const allNumbers = [number1, number2, number3, number4, number5, number6].map(num => num?.toString());
    const numbersInShow = this.toShow.match(/\d+/g) || [];
    
    const numbersObservable = from(numbersInShow).pipe(
      map(num => parseInt(num)),
      reduce((acc, curr) => acc + curr, 0),
      catchError(err => {
        console.error(err);
        return of(NaN); 
      })
    );

    if (numbersInShow) {
      numbersObservable.subscribe(
        sum => {
          const countOccurrences = (arr: string[]) => {
            return arr.reduce((acc, num) => {
              acc[num] = (acc[num] || 0) + 1;
              return acc;
            }, {} as { [key: number]: string });
          };
    
          const allNumbersCount = countOccurrences(allNumbers);          
          const numbersInShowCount = countOccurrences(numbersInShow);    
          const isEveryNumberIncluded = Object.keys(numbersInShowCount).every(key => {
            return allNumbersCount[key] && numbersInShowCount[key] <= allNumbersCount[key];
          });
    
          if (isEveryNumberIncluded) {
            if (result === sum) {
              alert("Čestitamo! Pogodili ste tačan broj!");
            } else {
              alert("Rezultat se ne poklapa sa unetim izrazom, pokušajte ponovo.");
            }
          } else {
            alert("Uneti brojevi se ne nalaze u izrazu ili su uneti više puta nego što je dozvoljeno.");
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
    this.toShow += value;          
  }

  clear() {
    this.toShow = '0';
  }

  back() {
    this.toShow = this.toShow.slice(0, -1);
  }
}
