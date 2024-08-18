import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { BASE_ULR } from 'src/app/enviroments/const/apiBaseUrl';
import { LetterWord } from '../interface/LetterWord-interface';

@Injectable({
  providedIn: 'root'
})
export class LetterWordService {

  constructor(private http: HttpClient) { }

  getAllLetterWords(): Observable<LetterWord[]> {
    return this.http.get<LetterWord[]>(`${BASE_ULR}/letter-words`)
      .pipe(
        catchError(error => {
          console.error('An error occurred:', error);
          return throwError(() => new Error('Something went wrong; please try again later.'));
        })
      )
  }

  public getRandomLetterWord(): Observable<LetterWord> {
    return this.http.get<LetterWord>(`${BASE_ULR}/letter-words/random`).pipe(
      catchError(error => {
        console.error('An error ocured:', error);
        return throwError(() => new Error('Something went wrong; please try again later.'))
      })
    )
  }
}
