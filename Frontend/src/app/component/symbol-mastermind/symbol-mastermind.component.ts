import { Component, ElementRef, inject, OnInit, QueryList, Renderer2, ViewChild, ViewChildren } from '@angular/core';
import { from, map, mergeMap, Observable, of, startWith, tap, toArray } from 'rxjs';
import { SymbolMastemindI } from 'src/app/interface/SymbolMastermind-interface';
import { SymbolMastermindService } from 'src/app/service/symbol-mastermind.service';

@Component({
  selector: 'app-symbol-mastermind',
  templateUrl: './symbol-mastermind.component.html',
  styleUrls: ['./symbol-mastermind.component.css']
})
export class SymbolMastermindComponent {
  private symbolMastermindService = inject(SymbolMastermindService);
  public symbols$: Observable<SymbolMastemindI[]>=this.symbolMastermindService.getAllSymbols();
  @ViewChildren('hit') hitElements!: QueryList<ElementRef>;
  @ViewChild('arr1') arr1Ref!: ElementRef;

  finalCombination: number[] = this.symbolMastermindService.generateFinalCombination();
  customerResult: number[] = [];
  counter = 0;

  constructor(private renderer: Renderer2) { }

  ngOnInit(): void {    
  };

  getSafeImage(symbols: SymbolMastemindI): string {
    if (symbols && symbols.image) {
      return 'data:image/jpeg;base64,' + symbols.image;
    } else {
      return '';
    }
  }

  onSignClick(id: number, event: Event): void {
    const div1Skocko = this.arr1Ref.nativeElement;
    const img = event.target as HTMLImageElement;
    let clone = this.renderer.createElement('img');
    this.renderer.setAttribute(clone, 'src', img.src);
    this.renderer.addClass(clone, img.className); 
    const targetElement = this.arr1Ref.nativeElement as HTMLElement;
    this.renderer.appendChild(targetElement, clone);
    this.customerResult.push(id);
    if (this.customerResult.length > 4) {
      alert('sad');
      this.customerResult.pop();
      const lastChild = div1Skocko.lastChild;
      if (lastChild) {
        this.renderer.removeChild(div1Skocko, lastChild);
      }
    }
  }

  validateGuess(): number[] {
    const tempRest$ = from(this.finalCombination).pipe(toArray());
    const secRest$ = from(this.customerResult).pipe(toArray());
    let matchArr: number[] = [];
    
    tempRest$.pipe(
      mergeMap(tempArray =>
        secRest$.pipe(
          map(secArray => {
            tempArray.forEach((tempR, index) => {
              if (tempR === secArray[index]) {
                tempArray[index] = null; 
                secArray[index] = null;
                matchArr.push(2);
              }
            });
  
            secArray.forEach((secR, index) => {
              if (secR !== null) {
                const matchIndex = tempArray.findIndex(tempRestItem => tempRestItem === secR);
                if (matchIndex >= 0) {
                  tempArray[matchIndex] = null;
                  secArray[index] = null;
                  matchArr.push(1);
                }
              }
            });
  
            secArray.forEach(secRestEnd => {
              if (secRestEnd !== null) {
                matchArr.push(0);
              }
            });
  
            return matchArr;
          })
        )
      )
    ).subscribe();
  
    return matchArr;
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
    }else{
      alert("das")
    }
  }

  onClear(): void {
    const div1Skocko = this.arr1Ref;
    if (div1Skocko?.nativeElement.childElementCount) {
      this.customerResult.pop();
      const lastChild = div1Skocko.nativeElement.lastChild;
      if (lastChild) {
        this.renderer.removeChild(div1Skocko.nativeElement, lastChild);
      }
    }
  }
}
