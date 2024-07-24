import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, map, Observable, of } from 'rxjs';
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

  allAssoc$: Observable<Association[]> = this.assocService.getAll();
  randIndexAssoc: Association;
  finallResult: string;
  itemText: { [key: string]: string[] };
  columnInput: { [key: string]: string } = { A: '', B: '', C: '', D: '' };
  columnSolution: { [key: string]: string } = { A: '', B: '', C: '', D: '' };
  isColumnGuessed: { [key: string]: boolean } = { A: false, B: false, C: false, D: false, F: false };
  itemClicked: { A: boolean[]; B: boolean[]; C: boolean[]; D: boolean[]; };

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
    this.assocService.getPosition(item).pipe(
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
    const solution = this.columnSolution[column];
    const input = this.columnInput[column];
    if (input === solution) {
      console.log(column);

      this.itemText[column] = this.randIndexAssoc.solutions['column ' + column];
      console.log(this.itemText[column]);
      this.isColumnGuessed[column.toUpperCase()] = true;
      this.scoreService.addToScore(5);
    } else {
      this['column' + column.toUpperCase() + 'Input'] = '';
    }
  }

  ngOnInit(): void {
    this.assocService.getRandomAssociation().subscribe(randAssoc => {
      this.randIndexAssoc = randAssoc;
      console.log(this.randIndexAssoc);
      this.columnSolution = {
        A: this.randIndexAssoc.solutions["Column A"],
        B: this.randIndexAssoc.solutions["Column B"],
        C: this.randIndexAssoc.solutions["Column C"],
        D: this.randIndexAssoc.solutions["Column D"]
      };
    });
  }
}
