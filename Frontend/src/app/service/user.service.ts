import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interface/User-Interface';
import { BASE_ULR } from '../const/apiBaseUrl';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public addUser(userscore: number, username: string): Observable<User> {
    const user: User = {
      userscore: userscore,
      username: username
    };
    
    return this.http.post<User>(`${BASE_ULR}/user/addUser`,user);
  }

  public allUsers(): Observable<User[]>{
    return this.http.get<User[]>(`${BASE_ULR}/user/allUsers`);
  }
}
