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
 
  ngOnInit() {
    this.numberStateService.fetchNumbers();
  } 
}
