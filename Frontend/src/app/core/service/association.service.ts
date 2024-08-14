import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { BASE_ULR } from '../../enviroments/const/apiBaseUrl';
import { Association } from '../interface/Association-interface';
import { Field } from '../interface/Field-interface';
import { MessageResponse } from '../interface/MessageResponse';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  constructor(private http: HttpClient, private sessionStorage: StorageService) { }

  getRandomAssociationOnlyById(): Observable<number> {
    return this.http.get<number>(`${BASE_ULR}/associations-game/random`);
  }

  getAssociationById(associationId: number): Observable<Association> {
    return this.http.get<Association>(`${BASE_ULR}/associations-game/associations/${associationId}`).pipe(
      catchError((error) => {
        console.error('Error details', error)
        return throwError(() => new Error(error.message || 'An unexpected error occured'));
      })
    )
  }

  getPosition(associationId: number, position: string): Observable<Field> {
    return this.http.get<Field>(`${BASE_ULR}/fields/search/${associationId}/${position}`);
  }

  getColumnByColumnPosition(associationId: number, columnPosition: string): Observable<Field[]> {
    return this.http.get<Field[]>(`${BASE_ULR}/fields/association/${associationId}/column/${columnPosition}`);
  }

  checkFinalSolution(associationId: number, userInput: string): Observable<boolean> {
    const url = `${BASE_ULR}/associations-game/checkFinalSolution/${associationId}/${userInput}`;
    return this.http.get<boolean>(url).pipe(
      catchError((error) => {
        console.error('Error details:', error);
        return throwError(() => new Error(error.message || 'An unexpected error occurred'));
      })
    );
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
}
