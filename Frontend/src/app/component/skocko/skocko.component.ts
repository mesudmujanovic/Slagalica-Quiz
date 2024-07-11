import { Component, ElementRef, inject, OnInit, QueryList, Renderer2, ViewChild, ViewChildren } from '@angular/core';
import { catchError, finalize, map, Observable, of, startWith, tap } from 'rxjs';
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
  @ViewChildren('hit') hitElements!: QueryList<ElementRef>;
  @ViewChild('arr1') arr1Ref!: ElementRef;

  ngOnInit(): void {
    this.generateFinalCombination();
  }  

  finalCombination: number[] = [];
  customerResult: number[] = [];
  counter = 0;

  constructor(private renderer: Renderer2) { }


  private generateFinalCombination(): void {
    this.symbols$.pipe(
      map(symbols => {
        const finalCombination = [];
        for (let i = 0; i < 4; i++) {
          let randomIndex = Math.floor(Math.random() * symbols.length);  
          let final = symbols[randomIndex];
          finalCombination.push(final.id);
        }
        return finalCombination;
      }),
      catchError(error => {
        console.error(error);
        return of([]);
      }),
      tap(finalCombination => {
        this.finalCombination = finalCombination;
        console.log(this.finalCombination);
      }),
      finalize(() => {
        console.log('Final combination generation completed.');
      })
    ).subscribe();
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
    let clone = this.renderer.createElement('img');
    this.renderer.setAttribute(clone, 'src', img.src);
    this.renderer.addClass(clone, img.className); 
    const targetElement = this.arr1Ref.nativeElement as HTMLElement;
    this.renderer.appendChild(targetElement, clone);
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
      const targetElement = this.hitElements.toArray()[this.counter].nativeElement;
      this.renderer.setProperty(targetElement, 'innerHTML', '');

      matcArr.forEach(item => {
        let h4 = this.renderer.createElement('h4');
        let text = this.renderer.createText(item.toString());

        if (item === 2) {
          this.renderer.addClass(h4, 'red-text');
        } else if (item === 1) {
          this.renderer.addClass(h4, 'yellow-text');
        } else {
          this.renderer.addClass(h4, 'black-text');
        }

        this.renderer.appendChild(h4, text);
        this.renderer.appendChild(targetElement, h4);
      });

      this.counter++;
      this.customerResult = [];

      if (JSON.stringify(matcArr) === JSON.stringify([2, 2, 2, 2])) {
        alert("Čestitamo, uspešno ste pogodili odgovarajuća mesta");
        setTimeout(() => location.reload(), 1400);
      }
      if (this.counter === 6) {
        alert("Žao mi je, niste uspeli da pogodite kombinaciju! Pokušajte ponovo");
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
