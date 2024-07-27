import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, throwError } from 'rxjs';
import { BASE_ULR } from '../../enviroments/const/apiBaseUrl';
import { Association } from '../interface/Association-interface';
import { Field } from '../interface/Field-interface';
import { MessageResponse } from '../interface/MessageResponse';

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Association[]> {
    return this.http.get<Association[]>(`${BASE_ULR}/associations-game/associations`);
  }

  getRandomAssociation(): Observable<Association> {
    return this.getAll().pipe(
      map(allRes => {
        const random = Math.floor(Math.random() * allRes.length + 1);
        return allRes[random];
      })
    );
  }

  getPosition(associationId: number, position: string): Observable<Field> {
    return this.http.get<Field>(`${BASE_ULR}/fields/search/${associationId}/${position}`);
  }

  checkColumnSolution(associationId: number, column: string, userInput: string): Observable<MessageResponse> {
    return this.http.get<MessageResponse>(`${BASE_ULR}/associations-game/checkSolution/${associationId}/${column}/${userInput}`)
    .pipe(
      catchError(error => {
        console.error('Error', error);
        return throwError(() => new Error('An error occurred while checking the solution.'));
      })
    )
  }

  // getColumnSolution(association: Association, key: string): string | undefined {
  //   const formattedKey = key.toLowerCase() + ':';
  //   const foundValue = association.solutions.find(item => {
  //     return item.toLowerCase().startsWith(formattedKey);
  //   });
  //   return foundValue ? foundValue.split(': ')[1] : undefined;
  // }

  // checkFinalSolution(randAssoc: Association, finallResult: string): boolean {
  //   const finalSolutionString =
  //     Array.isArray(randAssoc.finallSolutions) ? randAssoc.finallSolutions.join(', ') : randAssoc.finallSolutions;
  //   return finalSolutionString === finallResult;
  // }

  // getItemText(randAssoc: Association): { [key: string]: string[] } {
  //   return {
  //     'A': randAssoc.columnA,
  //     'B': randAssoc.columnB,
  //     'C': randAssoc.columnC,
  //     'D': randAssoc.columnD
  //   };
  // }

  updateColumnInputs(component: any): void {
    component.columnInput['A'] = component.columnSolution['A'];
    component.columnInput['B'] = component.columnSolution['B'];
    component.columnInput['C'] = component.columnSolution['C'];
    component.columnInput['D'] = component.columnSolution['D'];
  }
}
