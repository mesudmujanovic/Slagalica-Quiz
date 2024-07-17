import { Injectable } from '@angular/core';
import { Socket } from 'ngx-socket-io';

@Injectable({
  providedIn: 'root'
})
export class SocketService {

  constructor(private socket: Socket) { }

  sendMessageToUser(recipient: string, message: string) {
    this.socket.emit('message', { recipient, message });
  }

  getMessage() {
    return this.socket.fromEvent<string>('message');
  }

}
