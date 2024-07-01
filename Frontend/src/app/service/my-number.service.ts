import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MyNumber } from '../interface/MyNumber-Interface';
import { Observable } from 'rxjs';
import { BASE_ULR } from '../const/apiBaseUrl';

@Injectable({
  providedIn: 'root'
})
export class MyNumberService {

  constructor(private http: HttpClient) { }

  public getAllNumber(): Observable<MyNumber[]>{ 
    return this.http.get<MyNumber[]>(`${BASE_ULR}/quiz/getAllQuiz`)
  }
}
