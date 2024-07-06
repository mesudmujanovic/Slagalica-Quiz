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

  allAssoc$: Observable<Association[]>
  randIndexAssoc: any;
  finallSolution: string;
  finallResult: string;
  itemText: { [key: string]: string[] };
  columnAInput: string;
  columnBInput: string;
  columnCInput: string;
  columnDInput: string;
  isColumnGueseedA: boolean = false;
  isColumnGueseedB: boolean = false;
  isColumnGueseedC: boolean = false;
  isColumnGueseedD: boolean = false;
  isColumnGueseedF: boolean = false;


  constructor(private assocService: AssociationService,
    private scoreService: ScoreService,
    private router: Router) {
    this.itemText = { A: ["A1", "A2", "A3", "A4"], B: ["B1", "B2", "B3", "B4"], C: ["C1", "C2", "C3", "C4"], D: ["D1", "D2", "D3", "D4"] };
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
      this.columnAInput = this.randIndexAssoc.columnA_solution;
      this.columnBInput = this.randIndexAssoc.columnB_solution;
      this.columnCInput = this.randIndexAssoc.columnC_solution;
      this.columnDInput = this.randIndexAssoc.columnD_solution;

      this.isColumnGueseedF = true;
      this.scoreService.addToScore(15); // Dodaj 15 poena
       setTimeout(()=> {
        this.router.navigate(['/user']);
       },3000)
    } else {
      this.finallResult = '';
      alert("Try again")
    }
  }

  handleInputChangeB(): void {
    const solution = this.getSolutionForColumn('columnB');
    if (this.columnBInput === solution) {
      this.itemText['B'] = this.randIndexAssoc.columnB
      this.isColumnGueseedB = true;
      this.scoreService.addToScore(5);
    } else {
      this.columnBInput = '';
    }
  }

  handleInputChangeC(): void {
    const solution = this.getSolutionForColumn('columnB');
    if (this.columnCInput === solution) {
      this.itemText['C'] = this.randIndexAssoc.columnC
      this.isColumnGueseedC = true;
      this.scoreService.addToScore(5);
    } else {
      this.columnCInput = '';
    }
  }

  handleInputChangeD(): void {
    const solution = this.getSolutionForColumn('columnD');
    if (this.columnDInput === solution) {
      this.isColumnGueseedD = true;
      this.itemText['D'] = this.randIndexAssoc.columnD
      this.scoreService.addToScore(5);
    } else {
      this.columnDInput = '';
    }
  }

  handleInputChangeA(): void {
    const solution = this.getSolutionForColumn('columnA');
    if (this.columnAInput === solution) {
      this.itemText['A'] = this.randIndexAssoc.columnA;
      this.isColumnGueseedA = true;
      this.scoreService.addToScore(5);
    } else {
      this.columnAInput = '';
    }
  }

  getAllAssoc(): Observable<Association[]> {
    return this.allAssoc$ = this.assocService.getAll().pipe(
      catchError((error) => {
        console.log("error", error);
        return of([]);
      })
    )
  }

  ngOnInit(): void {
    this.getAllAssoc().pipe(
      map(resp => {
        console.log("resp", resp);
        const allAs = resp;
        const random = Math.floor(Math.random() * allAs.length)
        this.randIndexAssoc = allAs[random]
        this.randIndexAssoc.columnA_solution = this.getSolutionForColumn('columnA');
        this.randIndexAssoc.columnB_solution = this.getSolutionForColumn('columnB');
        this.randIndexAssoc.columnC_solution = this.getSolutionForColumn('columnC');
        this.randIndexAssoc.columnD_solution = this.getSolutionForColumn('columnD');
        this.finallSolution = this.randIndexAssoc.finallSolutions;
        console.log(this.randIndexAssoc);
        console.log(this.finallSolution);


      })
    ).subscribe(assoc => {
    });
  }

  getSolutionForColumn(column: string): string {
    const solution = this.randIndexAssoc.solutions.find(s => s.startsWith(column));
    if (solution) {
      const solutionWithoutPrefix = solution.split('_')[1];
      return solutionWithoutPrefix.replace('solution ', '');
    }
    return '';
  }

}
