import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculationService {
  private currValue: string = '0';
  public toShow: string = '0'; // Inicijalizirali smo toShow na '0'

  equals(
    num1: number | undefined,
    num2: number | undefined,
    num3: number | undefined,
    num4: number | undefined,
    num5: number | undefined,
    num6: number | undefined,
    result: number | undefined  
  ) {   
    // Izdvoji brojeve iz this.toShow koristeći regularni izraz
    const numbersInShow = this.toShow.match(/\d+/g);
    
    // Ako su pronađeni brojevi, pretvori ih u niz brojeva
    const numbers = numbersInShow ? numbersInShow.map(num => parseInt(num)) : [];
    
    // Izračunaj sumu svih brojeva uključenih u this.toShow i unesene brojeve
    const sum = numbers.reduce((acc, curr) => acc + curr, 0);
  console.log(this.toShow);
  console.log(result);
  console.log(sum);
  
  
  
    try {
      // Provjeri da li je result definiran i da li se poklapa sa izračunatom sumom
      if (typeof result === 'number' && result === sum) {
        alert("Čestitamo! Pogodili ste tačan broj!");
      } else {
        alert("Rezultat se ne poklapa sa unetim izrazom, pokušajte ponovo.");
      }
    } catch (err) {
      console.error(err);
      alert("Došlo je do greške prilikom izračunavanja izraza.");
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
