import { Component, ElementRef, inject, QueryList, Renderer2, ViewChild, ViewChildren } from '@angular/core';
import { catchError, from, map, mergeMap, Observable, of, Subject, takeUntil, toArray } from 'rxjs';
import { SymbolMastemindI } from 'src/app/core/interface/SymbolMastermind-interface';
import { SymbolMastermindService } from 'src/app/core/service/symbol-mastermind.service';

@Component({
  selector: 'app-symbol-mastermind',
  templateUrl: './symbol-mastermind.component.html',
  styleUrls: ['./symbol-mastermind.component.scss']
})
export class SymbolMastermindComponent {
  private symbolMastermindService = inject(SymbolMastermindService);
  public symbols$: Observable<SymbolMastemindI[]> = this.symbolMastermindService.getAllSymbols();
  finalCombination: number[] = this.symbolMastermindService.generateFinalCombination();
  private destroy$ = new Subject<void>();

  @ViewChildren('hit') hitElements!: QueryList<ElementRef>;
  @ViewChild('arr1') arr1Ref!: ElementRef;
  allSign: number[] = [0, 1, 2, 3, 4, 5]
  customerResult: number[] = [];
  counter: number = 0;

  constructor(private renderer: Renderer2) { }
  
  ngOnInit(): void {
    console.log(this.finalCombination);

  };

  getSafeImage(symbols: SymbolMastemindI): string {
    return this.symbolMastermindService.getSafeImage(symbols);
  }

  onSignClick(id: number, event: Event): void {
    const img = event.target as HTMLImageElement;
    let clone = this.renderer.createElement('img');
    this.renderer.setAttribute(clone, 'src', img.src);
    this.renderer.addClass(clone, img.className); 
    this.renderer.appendChild(this.arr1Ref.nativeElement, clone);
    this.customerResult.push(id);
  
    if (this.customerResult.length > 4) {
      alert('Maksimalan broj znakova je 4.');
      this.customerResult.pop();
      this.renderer.removeChild(this.arr1Ref.nativeElement, clone);
    }
  }
  

  validateGuess(): Observable<number[]> {
    return from(this.finalCombination).pipe(
      toArray(),
      mergeMap(finalArray =>
        from(this.customerResult).pipe(
          toArray(),
          map(customerArray => {
            let matchArr: number[] = [];

            finalArray.forEach((finalNum, index) => {
              if (finalNum === customerArray[index]) {
                matchArr.push(2);
                finalArray[index] = -1; 
                customerArray[index] = -1;
              }
            });

            customerArray.forEach((customerNum, index) => {
              if (customerNum !== -1) {
                let matchIndex = finalArray.findIndex(finalNum => finalNum === customerNum);
                if (matchIndex !== -1) {
                  matchArr.push(1);
                  finalArray[matchIndex] = -1;
                  customerArray[index] = -1;
                }
              }
            });

            while (matchArr.length < 4) {
              matchArr.push(0);
            }

            return matchArr;
          })
        )
      ),
      takeUntil(this.destroy$),
      catchError(error => {
        console.error('Greška pri validaciji: ', error);
        return of([]); 
      })
    );
  }

  onGuess(): void {
    if (this.customerResult.length === 4) {
      this.validateGuess().pipe(
        takeUntil(this.destroy$) 
      ).subscribe(matchArr => {
        const targetElement = this.hitElements.toArray()[this.counter].nativeElement;
        this.renderer.setProperty(targetElement, 'innerHTML', '');
  
        matchArr.forEach(item => {
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
  
        if (matchArr.every(match => match === 2)) {
          alert("Čestitamo, uspešno ste pogodili odgovarajuća mesta");
          setTimeout(() => location.reload(), 1400);
        }
        if (this.counter === 6) {
          alert("Žao mi je, niste uspeli da pogodite kombinaciju! Pokušajte ponovo");
          location.reload();
        }
      });
    } else {
      alert("Potrebno je odabrati tačno 4 znaka.");
    }
  }
  
  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  onClear(): void {
    const arr1Ref = this.arr1Ref;
    if (arr1Ref?.nativeElement.childElementCount) {
      this.customerResult.pop();
      const lastChild = arr1Ref.nativeElement.lastChild;
      if (lastChild) {
        this.renderer.removeChild(arr1Ref.nativeElement, lastChild);
      }
    }
  }
}
