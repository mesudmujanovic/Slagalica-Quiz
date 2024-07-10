import { Component, inject, OnInit } from '@angular/core';
import { map, Observable } from 'rxjs';
import { SymbolMastemindI } from 'src/app/interface/SymbolMastermind-interface';
import { SymbolMastermindService } from 'src/app/service/symbol-mastermind.service';

@Component({
  selector: 'app-skocko',
  templateUrl: './skocko.component.html',
  styleUrls: ['./skocko.component.css']
})
export class SkockoComponent implements OnInit {
  private symbolMastermindService = inject(SymbolMastermindService);
  public symbols$: Observable<SymbolMastemindI[]>=this.symbolMastermindService.getAllSymbols();

  ngOnInit(): void {
    this.generateFinalCombination();
  }  

  finalCombination: number[] = [];
  customerResult: number[] = [];
  counter = 0;

  constructor() { }

  private generateFinalCombination(): void {
    this.symbols$.subscribe(
      symbols => {
        for (let i = 0; i < 4; i++) {
          let randomIndex = Math.floor(Math.random() * symbols.length);
          console.log(randomIndex);
                  
          let final = symbols[randomIndex];
          this.finalCombination.push(final.id);
          console.log(this.finalCombination);
          
        }
      },
      error => console.error(error)
    );
  }

  getSafeImage(symbols: SymbolMastemindI): string {
    if (symbols && symbols.image) {
      return 'data:image/jpeg;base64,' + symbols.image;
    } else {
      return '';
    }
  }

  onSignClick(id: number, event: Event): void {
    const img = event.target as HTMLImageElement;
    let clone = img.cloneNode(true) as HTMLImageElement;
    document.querySelector('.arr1-1')?.appendChild(clone);
    this.customerResult.push(id);
  }

  validateGuess(): number[] {
    const matcArr = [];
    const tempRest = [...this.finalCombination];
    const secRest = [...this.customerResult];
    console.log(secRest);
    
    tempRest.forEach((tempR, index) => {
      if (tempR === secRest[index]) {
        delete tempRest[index];
        delete secRest[index];
        matcArr.push(2);
      }
    });

    secRest.forEach((secR, index) => {
      const hasMatch = tempRest.findIndex(tempRestItem => tempRestItem === secR);
      if (hasMatch >= 0) {
        delete tempRest[hasMatch];
        delete secRest[index];
        matcArr.push(1);
      }
    });

    for (const secRestEnd of secRest) {
      if (secRestEnd !== undefined) {
        matcArr.push(0);
      }
    }

    return matcArr;
  }

  onGuess(): void {
    if (this.customerResult.length === 4) {
      const matcArr = this.validateGuess();
      let matcArrText = matcArr.map(item => {
        if (item === 2) return `<h4 class='red-text'>2</h4>`;
        if (item === 1) return `<h4 class='yellow-text'>1</h4>`;
        return `<h4 class='black-text'>0</h4>`;
      }).join("");

      document.querySelectorAll('.hit')[this.counter].innerHTML = matcArrText;
      this.counter++;
      this.customerResult = [];
      if (JSON.stringify(matcArr) === JSON.stringify([2, 2, 2, 2])) {
        alert("Cestitamo, upsesno ste pogodili odgovarajuca mesta");
        setTimeout(() => location.reload(), 1400);
      }
      if (this.counter === 6) {
        alert("Zao mi je, niste uspeli da pogodite kombinaciju! Pokusajte ponovo");
        location.reload();
      }
    }
  }

  onClear(): void {
    let div1Skocko = document.querySelector('.arr1-1');
    if (div1Skocko?.childElementCount) {
      this.customerResult.pop();
      div1Skocko.removeChild(div1Skocko.lastChild as Node);
    }
  }
}
