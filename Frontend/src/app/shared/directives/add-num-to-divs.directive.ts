import { Directive, ElementRef, HostListener, inject, Input, QueryList, Renderer2 } from '@angular/core';
import { NumberStateService } from 'src/app/core/service/number-state.service';

@Directive({
  selector: '[appAddNumToDivs]'
})
export class AddNumToDivsDirective {
  private numberStateService = inject(NumberStateService);

  @Input() currentDivIndex: number = 0;
  @Input() counterButton: number = 0;
  @Input() numDivs: QueryList<ElementRef> = new QueryList<ElementRef>();
  @Input() containerCalc: ElementRef | undefined;
  @Input() operationType: 'numbers' | 'letters' = 'numbers';

  constructor(
    private renderer: Renderer2,
  ) { }

  @HostListener('click') onClick() {
    let currentContent = '';
    if (this.operationType === 'numbers') {
      currentContent = this.numberStateService.numbers['number' + this.currentDivIndex]?.toString() ?? '';
    } else if (this.operationType === 'letters') {
      currentContent = 'A';
    }

    const currentDiv = this.numDivs.toArray()[this.currentDivIndex - 1]?.nativeElement;

    if (currentDiv) {
      if (currentDiv.classList.contains('numSpin')) {
        currentDiv.textContent = currentContent;
        this.renderer.removeClass(currentDiv, 'numSpin');
        this.currentDivIndex++;
        const nextDiv = this.numDivs.toArray()[this.currentDivIndex - 1]?.nativeElement;
        if (nextDiv) {
          this.renderer.addClass(nextDiv, 'numSpin');
        }
        // this.counterButton++;
        // if (this.counterButton === 6 && this.containerCalc) {
        //   this.renderer.removeClass(this.containerCalc.nativeElement, 'hide');
        // }

      } else {
        this.renderer.addClass(currentDiv, 'numSpin');
      }
    }
  }
}
