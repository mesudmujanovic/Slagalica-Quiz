import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MyNumber } from '../interface/MyNumber-Interface';
import { catchError, map, Observable, throwError } from 'rxjs';
import { BASE_ULR } from '../../enviroments/const/apiBaseUrl';

@Injectable({
  providedIn: 'root'
})
export class MyNumberService {

  constructor(private http: HttpClient) { }

  public getAllNumber(): Observable<MyNumber[]> {
    return this.http.get<MyNumber[]>(`${BASE_ULR}/number-game/my-numbers`).pipe(
      catchError(err => {
        console.error('Error problwm:', err);
        return throwError(err);
      })
    )
  }
}
