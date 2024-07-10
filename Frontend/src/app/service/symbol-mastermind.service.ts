import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { SymbolMastemindI } from '../interface/SymbolMastermind-interface';
import { BASE_ULR } from '../const/apiBaseUrl';

@Injectable({
  providedIn: 'root'
})
export class SymbolMastermindService {

  constructor(private http: HttpClient) { }

  public getAllSymbols(): Observable<SymbolMastemindI[]>{
    return this.http.get<SymbolMastemindI[]>(`${BASE_ULR}/assoc/symbols`).pipe(
      catchError(err => {
        console.error('Error occurred:', err);
        return throwError(err);
      })
    )
  }

  public saveSymbolMastermin(symbolMastemind: SymbolMastemindI): Observable<SymbolMastemindI>{
    const formData: FormData = new FormData();
    formData.append('name', symbolMastemind.name);
    formData.append('image', symbolMastemind.image);
    return this.http.post<SymbolMastemindI>(`${BASE_ULR}/assoc/saveimg`, formData).pipe(
      catchError(err => {
        console.error('Error occurred:', err);
        return throwError(err);
      })
    );
  }

}
