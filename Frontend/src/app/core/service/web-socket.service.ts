import { Injectable } from '@angular/core';
import { WebSocketSubject, webSocket } from 'rxjs/webSocket';
import { Observable, tap } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  private socket$: WebSocketSubject<any>;
  
  constructor() {
    this.socket$ = webSocket('ws://localhost:8080/number-game-socket');
  }

  sendMessage(message: any) {
    console.log('Sending message:', message);
    this.socket$.next(message);
  }

  getMessages(): Observable<any> {
    return this.socket$.pipe(
      tap(message => console.log('Received message:', message))
    );
  }

}
