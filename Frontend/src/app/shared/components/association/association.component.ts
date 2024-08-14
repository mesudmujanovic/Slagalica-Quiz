import { Component, inject } from '@angular/core';
import { catchError, EMPTY, map, Observable, of, Subject, switchMap, takeUntil } from 'rxjs';
import { Association } from 'src/app/core/interface/Association-interface';
import { Field } from 'src/app/core/interface/Field-interface';
import { AssociationService } from 'src/app/core/service/association.service';
import { StorageService } from 'src/app/core/service/storage.service';

@Component({
  selector: 'app-association',
  templateUrl: './association.component.html',
  styleUrls: ['./association.component.scss']
})
export class AssociationComponent {
  private assocService = inject(AssociationService);
  private sessionStorage = inject(StorageService);
  private destroy$ = new Subject<void>();
  private associationId: number;

  randIndexAssoc: Association;
  finallResult: string;
  itemText: { [key: string]: string[] };
  columnInput: { [key: string]: string } = { A: '', B: '', C: '', D: '' };
  isColumnGuessed: { [key: string]: boolean } = { A: false, B: false, C: false, D: false };
  revealedItems = {
    A: [false, false, false, false],
    B: [false, false, false, false],
    C: [false, false, false, false],
    D: [false, false, false, false]
  };
  constructor() {
    this.itemText = {
      A: ["A1", "A2", "A3", "A4"],
      B: ["B1", "B2", "B3", "B4"],
      C: ["C1", "C2", "C3", "C4"],
      D: ["D1", "D2", "D3", "D4"]
    };
  }

  ngOnInit() {
    this.associationId = Number(this.sessionStorage.getItem("associationId"));
    this.assocService.getRandomAssociationOnlyById().subscribe(a => {
      this.associationId = a;
    }
    )
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }

  showText(item: string, column: string, index: number): void {
    this.assocService.getPosition(this.associationId, item).pipe(
      map((field: Field) => field.text),
      catchError(error => {
        console.error('Greška pri pretrazi:', error);
        return of('');
      }),
      takeUntil(this.destroy$)
    ).subscribe(
      text => {
        this.itemText[column] = this.itemText[column] || [];
        this.itemText[column][index] = text;
        this.revealedItems[column] = this.revealedItems[column] || [];
        this.revealedItems[column][index] = true;
      }
    );
  }

  finalColumn(): void {
    if (this.associationId === null) {
      console.error("No association ID available");
      return;
    }
    this.assocService.checkFinalSolution(this.associationId, this.finallResult).pipe(
      takeUntil(this.destroy$)
    ).subscribe({
      next: (result) => {
        console.log('Final solution checked:', result);
        this.sessionStorage.removeItem("randomAssociationId");
        this.assocService.getRandomAssociation().subscribe(res => {
          if (res) {
            this.associationId = res.id;
            this.sessionStorage.setItem("randomAssociationId", this.associationId.toString());
            this.columnInput = (({ A, B, C, D }) => ({ A, B, C, D }))(res.solutions);
            Object.keys(this.isColumnGuessed).forEach(key => {
              this.isColumnGuessed[key] = true;
            });
            res.fields.forEach(field => {
              const column = field.columnPosition;
              const position = field.position;
              const index = this.itemText[column].indexOf(position);
              ////                       [A,A,A,A]         (0,1,2,3)
              if (index != -1) {
                this.itemText[column][index] = field.text;
                ////  [A]     [0 prvi field]   = prvi field -> field.text 
              }
            });
          }
        });
      },
      error: (error) => {
        console.error('Error checking final solution:', error);
      }
    });
  }

  handleInputChange(column: string): void {
    const input = this.columnInput[column];
    this.assocService.checkColumnSolution(this.associationId, column, input).pipe(
      switchMap(checkSolution => {
        if (checkSolution.message) {
          return this.assocService.getColumnByColumnPosition(this.associationId, column);
        } else {
          return EMPTY;
        }
      }),
      takeUntil(this.destroy$)
    ).subscribe({
      next: (fields) => {
        this.itemText[column] = fields.map(field => field.text);
        this.isColumnGuessed[column.toUpperCase()] = true;
      },
      error: (error) => {
        console.error('Error handling input change:', error);
      }
    });
  }
}
