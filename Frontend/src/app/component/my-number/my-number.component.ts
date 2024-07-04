import { Component } from '@angular/core';
import { NumberStateService } from 'src/app/service/number-state.service';

@Component({
  selector: 'app-my-number',
  templateUrl: './my-number.component.html',
  styleUrls: ['./my-number.component.css']
})
export class MyNumberComponent {
  currentDivIndex: number = 1;
  public counter: number = 60
  public toShow: any;
  public currValue: string = '';
  public counterButton: number = 0;
  numbers: (number | undefined)[] = [undefined, undefined, undefined, undefined, undefined, undefined];

  constructor( 
               public numberStateService: NumberStateService
             ) { }

    addNumToDivs() {
      const currentNum = this.numberStateService['number' + this.currentDivIndex];
      const currentDiv = document.getElementById('number' + this.currentDivIndex);

      if (currentDiv) {
        if (currentDiv.classList.contains('numSpin')) {
          currentDiv.textContent = currentNum?.toString() ?? '';
          currentDiv.classList.remove('numSpin');
          this.currentDivIndex++;
          const nextDiv = document.getElementById('number' + this.currentDivIndex);
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
      this.numberStateService.fetchNumbers();
    } 
}
