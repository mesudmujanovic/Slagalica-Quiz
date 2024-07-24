import { Component, inject } from '@angular/core';
import { CalculationService } from '../../../core/service/calculation.service';
import { NumberStateService } from '../../../core/service/number-state.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  private calculationService = inject(CalculationService);
  private numberStateService = inject(NumberStateService);
  constructor(){}
 
  ngOnInit() {
    this.numberStateService.fetchNumbers();
  } 
  
  get toShow(): string {
    return this.calculationService.toShow;
  }

  set toShow(value: string) {
    this.calculationService.toShow = value;
  }
  equals() {    
      const [number1, number2, number3, number4, number5, number6, result] = this.numberStateService.getNumbers();
      this.calculationService.equals({ number1, number2, number3, number4, number5, number6, result: result });
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
}
