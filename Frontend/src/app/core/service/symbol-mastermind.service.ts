import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, finalize, map, Observable, of, throwError } from 'rxjs';
import { SymbolMastemindI } from '../interface/SymbolMastermind-interface';
import { BASE_ULR } from '../../enviroments/const/apiBaseUrl';

@Injectable({
  providedIn: 'root'
})
export class SymbolMastermindService {

  constructor(private http: HttpClient) { }

  public getAllSymbols(): Observable<SymbolMastemindI[]>{
    return this.http.get<SymbolMastemindI[]>(`${BASE_ULR}/symbol-game/symbols`).pipe(
      catchError(err => {
        console.error('Error occurred:', err);
        return throwError(err);
      })
    ) 
  }

  public generateFinalCombination(): number[] {
    const finalCombination = [];
    for (let i = 0; i < 4; i++) {
      let randomNumber = Math.floor(Math.random() * 6) + 1;  
      finalCombination.push(randomNumber);
    }
    return finalCombination;
  }
  
  public getSafeImage(symbols: SymbolMastemindI): string {
    if (symbols && symbols.image) {
      return 'data:image/jpeg;base64,' + symbols.image;
    } else {
      return '';
    }
  }

}
