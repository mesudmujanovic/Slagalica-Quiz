import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, map, of } from 'rxjs';
import { Association } from 'src/app/interface/Association-interface';
import { AssociationService } from 'src/app/service/association.service';
import { ScoreService } from 'src/app/service/score.service';

@Component({
  selector: 'app-association',
  templateUrl: './association.component.html',
  styleUrls: ['./association.component.css']
})
export class AssociationComponent {

  allAssoc$: Observable<Association[]> = this.assocService.getAll();
  randIndexAssoc: Association;
  finallSolution: string;
  finallResult: string;
  itemText: { [key: string]: string[] };
  columnAInput: string;
  columnBInput: string;
  columnCInput: string;
  columnDInput: string;
  columnASolution;
  columnBSolution;
  columnCSolution;
  columnDSolution;
  isColumnGueseedA: boolean = false;
  isColumnGueseedB: boolean = false;
  isColumnGueseedC: boolean = false;
  isColumnGueseedD: boolean = false;
  isColumnGueseedF: boolean = false;

  constructor(private assocService: AssociationService,
    private scoreService: ScoreService,
    private router: Router) {
    this.itemText = { 
      A: ["A1", "A2", "A3", "A4"], 
      B: ["B1", "B2", "B3", "B4"],
      C: ["C1", "C2", "C3", "C4"],
      D: ["D1", "D2", "D3", "D4"]
    };
  }
  
  showText(item: string, column: string, index: number): void {
    this.itemText[column][index] = item;
  }

  finallColumn() {
    if (this.finallResult == this.finallSolution) {
      this.itemText['A'] = this.randIndexAssoc.columnA;
      this.itemText['B'] = this.randIndexAssoc.columnB
      this.itemText['C'] = this.randIndexAssoc.columnC
      this.itemText['D'] = this.randIndexAssoc.columnD
      this.columnAInput = this.columnASolution;
      this.columnBInput = this.columnBSolution;
      this.columnCInput = this.columnCSolution;
      this.columnDInput = this.columnDSolution;
      this.isColumnGueseedF = true;
      this.scoreService.addToScore(15); 
       setTimeout(()=> {
        this.router.navigate(['/user']);
       },3000)
    } else {
      this.finallResult = '';
      alert("Try again")
    }
  }

  handleInputChange(column: string): void {
    const solution = this['column' + column.toUpperCase() + 'Solution']; 
    const input = this['column' + column.toUpperCase() + 'Input']; 

    if (input === solution) {
      this.itemText[column] = this.randIndexAssoc['column' + column];
      this['isColumnGueseed' + column.toUpperCase()] = true;
      this.scoreService.addToScore(5);
    } else {
      this['column' + column.toUpperCase() + 'Input'] = '';
    }
  }

  ngOnInit(): void {
    this.allAssoc$.pipe(
      map(allRes => {
        const allAs = allRes;
        const random = Math.floor(Math.random() * allAs.length);
        this.randIndexAssoc = allAs[random];  
        this.columnASolution = this.getColumnSolution('columnA');
        this.columnBSolution = this.getColumnSolution('columnB');
        this.columnCSolution = this.getColumnSolution('columnC');
        this.columnDSolution = this.getColumnSolution('columnD');
        this.finallSolution = this.randIndexAssoc.finallSolutions;
      })
    ).subscribe()
  }
  
  getColumnSolution(key: string): string | undefined {
    const formattedKey = key.toLowerCase() + ':';
    const foundValue = this.randIndexAssoc.solutions.find(item => {
      return item.toLowerCase().startsWith(formattedKey);
    });
    return foundValue ? foundValue.split(': ')[1] : undefined;
  }
  
}
