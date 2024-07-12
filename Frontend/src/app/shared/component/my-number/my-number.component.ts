import { Component, ElementRef, QueryList, Renderer2, ViewChildren } from '@angular/core';
import { Observable } from 'rxjs';
import { NumberStateService } from 'src/app/core/service/number-state.service';

@Component({
  selector: 'app-my-number',
  templateUrl: './my-number.component.html',
  styleUrls: ['./my-number.component.css']
})
export class MyNumberComponent {

  @ViewChildren('numDiv') numDivs!: QueryList<ElementRef>;  
  @ViewChildren('containerCalc', { read: ElementRef }) containerCalc!: QueryList<ElementRef>;

  currentDivIndex: number = 1;
  public counter: number = 60
  public toShow: string;
  public counterButton: number = 0;
  numbers: (number | undefined)[] = [undefined, undefined, undefined, undefined, undefined, undefined];
  result$: Observable<number | undefined>;
  
  constructor(private numberStateService: NumberStateService,
             private renderer: Renderer2 )
     {this.result$ = this.numberStateService.getResult();
     }
     
  addNumToDivs() {
    const currentNum = this.numberStateService.numbers['number' + this.currentDivIndex];
    const currentDiv = this.numDivs.toArray()[this.currentDivIndex - 1]?.nativeElement;

    if (currentDiv) {
      if (currentDiv.classList.contains('numSpin')) {
        currentDiv.textContent = currentNum?.toString() ?? '';
        this.renderer.removeClass(currentDiv, 'numSpin');
        this.currentDivIndex++;
        const nextDiv = this.numDivs.toArray()[this.currentDivIndex - 1]?.nativeElement;
        if (nextDiv) {
          this.renderer.addClass(nextDiv, 'numSpin');
        }
        this.counterButton++;
        if (this.counterButton === 6) {
          const calcDiv = this.containerCalc.first?.nativeElement;
          if (calcDiv) {
            this.renderer.removeClass(calcDiv, 'hide');
          }
        }
      } else {
        this.renderer.addClass(currentDiv, 'numSpin');
      }
    }
  }
 

}