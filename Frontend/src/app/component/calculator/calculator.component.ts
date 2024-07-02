import { Component } from '@angular/core';
import { CalculationService } from '../../service/calculation.service';
import { NumberStateService } from '../../service/number-state.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
 
  constructor(public calculationService: CalculationService,
              public numberStateService: NumberStateService){}

  equals() {    
    const [num1, num2, num3, num4, num5, num6, result] = this.numberStateService.getNumbers();
    this.calculationService.equals(num1, num2, num3, num4, num5, num6, result);
  }

  writeToInput(value: string) {
    this.calculationService.writeToInput(value);
  }

  clear() {
    this.calculationService.clear();
  }

  back() {
    this.calculationService.back();
  }
 
  ngOnInit() {
    this.numberStateService.fetchNumbers();
  } 
}
