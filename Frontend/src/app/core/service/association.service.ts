import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Association } from '../interface/Association-interface';
import { BASE_ULR } from '../../enviroments/const/apiBaseUrl';

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Association[]>{
    return this.http.get<Association[]>(`${BASE_ULR}/assoc/all`);
  }

  getRandomAssociation(): Observable<Association> {
    return this.getAll().pipe(
      map(allRes => {
        const random = Math.floor(Math.random() * allRes.length);
        return allRes[random];
      })
    );
  }

  getColumnSolution(association: Association, key: string): string | undefined {
    const formattedKey = key.toLowerCase() + ':';
    const foundValue = association.solutions.find(item => {
      return item.toLowerCase().startsWith(formattedKey);
    });
    return foundValue ? foundValue.split(': ')[1] : undefined;
  }

  checkFinalSolution(randAssoc: Association, finallResult: string): boolean {
    const finalSolutionString =
    Array.isArray(randAssoc.finallSolutions) ? randAssoc.finallSolutions.join(', ') : randAssoc.finallSolutions; 
    return finalSolutionString === finallResult;
  }
  
  getItemText(randAssoc: Association): { [key: string]: string[] } {
    return {
      'A': randAssoc.columnA,
      'B': randAssoc.columnB,
      'C': randAssoc.columnC,
      'D': randAssoc.columnD
    };
  }

  updateColumnInputs(component: any): void {
    component.columnInput['A'] = component.columnSolution['A'];
    component.columnInput['B'] = component.columnSolution['B'];
    component.columnInput['C'] = component.columnSolution['C'];
    component.columnInput['D'] = component.columnSolution['D'];
  }
}
