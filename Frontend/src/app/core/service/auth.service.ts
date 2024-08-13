import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { StorageService } from './storage.service';
import { BASE_ULR } from 'src/app/enviroments/const/apiBaseUrl';
import { map, Observable } from 'rxjs';
import { User } from '../interface/User-Interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private storageService = inject(StorageService);

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<User> {
    return this.http.post<User>(`${BASE_ULR}/api/auth/login`, { username, password }).pipe(
      map((response: User) => {
        if (response) {
          this.storageService.setItem('currentUser', JSON.stringify(response));
        }
        return response;
      })
    );
  }

  signup(username: string, password: string): Observable<User> {
    return this.http.post<User>(`${BASE_ULR}/api/auth/signup`, { username, password });
  }

  logout(): void {
    this.storageService.removeItem('currentUser');
  }
}
