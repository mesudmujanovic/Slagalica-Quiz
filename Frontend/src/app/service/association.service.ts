import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Association } from '../interface/Association-interface';
import { BASE_ULR } from '../const/apiBaseUrl';

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Association[]>{
    return this.http.get<Association[]>(`${BASE_ULR}/assoc/all`);
  }
}
