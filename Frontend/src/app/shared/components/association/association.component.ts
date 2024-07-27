import { Component, inject } from '@angular/core';
import { catchError, map, Observable, of, switchMap } from 'rxjs';
import { Association } from 'src/app/core/interface/Association-interface';
import { Field } from 'src/app/core/interface/Field-interface';
import { AssociationService } from 'src/app/core/service/association.service';
import { ScoreService } from 'src/app/core/service/score.service';

@Component({
  selector: 'app-association',
  templateUrl: './association.component.html',
  styleUrls: ['./association.component.css']
})
export class AssociationComponent {
  private assocService = inject(AssociationService);

  allAssoc$: Observable<Association[]> = this.assocService.getAll();
  randIndexAssoc: Association;
  finallResult: string;
  itemText: { [key: string]: string[] };
  columnInput: { [key: string]: string } = { A: '', B: '', C: '', D: '' };
  columnSolution: { [key: string]: string } = { A: '', B: '', C: '', D: '' };
  isColumnGuessed: { [key: string]: boolean } = { A: false, B: false, C: false, D: false, F: false };
  itemClicked: { A: boolean[]; B: boolean[]; C: boolean[]; D: boolean[]; };

  constructor() {
    this.itemText = {
      A: ["A1", "A2", "A3", "A4"],
      B: ["B1", "B2", "B3", "B4"],
      C: ["C1", "C2", "C3", "C4"],
      D: ["D1", "D2", "D3", "D4"]
    };
  }

  ngOnInit(): void {    
}

  showText(item: string, column: string, index: number): void {
    const number: number = 1;
    this.assocService.getPosition(number,item).pipe(
      map((field: Field) => field.text),
      catchError(error => {
        console.error('Greška pri pretrazi:', error);
        return of('');
      })
    ).subscribe(
      text => {
        this.itemText[column][index] = text;
      }
    );
  }

  // finallColumn() {
  //   if (this.assocService.checkFinalSolution(this.randIndexAssoc, this.finallResult)) {
  //     this.itemText = this.assocService.getItemText(this.randIndexAssoc);
  //     this.assocService.updateColumnInputs(this);
  //     this.isColumnGuessed['F'] = true;
  //     this.scoreService.addToScore(15);
  //     setTimeout(() => {
  //       this.router.navigate(['/user']);
  //     }, 3000);
  //   } else {
  //     this.finallResult = '';
  //     alert("Try again");
  //   }
  // }

  handleInputChange(column: string): void {    
    const number: number = 1;
    const input = this.columnInput[column]; 
    this.assocService.checkColumnSolution(number, column, input).subscribe(
      a => console.log(a)
    );
    // this.assocService.getRandomAssociation().subscribe(randAssoc => {
    //   this.randIndexAssoc = randAssoc;
    //   console.log(this.randIndexAssoc);
    //   this.columnSolution = {
    //     A: this.randIndexAssoc.solutions["columnA"],
    //     B: this.randIndexAssoc.solutions["columnB"],
    //     C: this.randIndexAssoc.solutions["columnC"],
    //     D: this.randIndexAssoc.solutions["columnD"]
    //   };
    // });
    // if (input === solution) {
    //   console.log(column);

    //   this.itemText[column] = this.randIndexAssoc.fields
    //     .filter(field => field.position.startsWith(column))
    //     .map(field => field.text);
    //   console.log(this.itemText[column]);
    //   this.isColumnGuessed[column.toUpperCase()] = true;
    //   this.scoreService.addToScore(5);
    // } else {
    //   this.columnInput[column] = '';
    // }
  }
}