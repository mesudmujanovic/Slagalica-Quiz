import { Component } from '@angular/core';
import { SocketService } from 'src/app/core/service/socket.service';

@Component({
  selector: 'app-multiplayer',
  templateUrl: './multiplayer.component.html',
  styleUrls: ['./multiplayer.component.css']
})
export class MultiplayerComponent {
  
  recipient: string = '';
  messageToSend: string = '';
  receivedMessage: string = '';

  constructor(private socketService: SocketService) { }

  sendMessage() {
    this.socketService.sendMessageToUser(this.recipient, this.messageToSend);
    this.messageToSend = ''; // Resetovanje polja za unos poruke
  }
}
