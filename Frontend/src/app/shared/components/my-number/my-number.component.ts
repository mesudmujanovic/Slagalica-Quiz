import { Component, ElementRef, inject, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ChatMessage } from 'src/app/core/interface/ChatMessage';
import { NumberStateService } from 'src/app/core/service/number-state.service';
import { WebSocketService } from 'src/app/core/service/web-socket.service';

@Component({
  selector: 'app-my-number',
  templateUrl: './my-number.component.html',
  styleUrls: ['./my-number.component.scss']
})
export class MyNumberComponent {
  private numberStateService = inject(NumberStateService);
  private chatService = inject(WebSocketService);

  @ViewChildren('numDiv') numDivs: QueryList<ElementRef>;
  @ViewChild('containerCalc') containerCalc: ElementRef | undefined;

  currentDivIndex: number = 1;
  public counter: number = 60;
  public toShow: string;
  public counterButton: number = 0;
  numbers: (number | undefined)[] = [undefined, undefined, undefined, undefined, undefined, undefined];
  result$: Observable<number | undefined>;
  currentPlayer: number = 1; 
  playerResults: number[] = [0, 0]; 
  messageInput: string = '';
  userId: string="";
  messageList: any[] = [];

  constructor(
    private route: ActivatedRoute,
    ){
      this.result$ = this.numberStateService.getResult();

  }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params["userId"];
    this.chatService.joinRoom("ABC");
    this.lisenerMessage();
  }

  sendMessage() {
    const chatMessage = {
      message: this.messageInput,
      user: this.userId
    }as ChatMessage
    this.chatService.sendMessage("ABC", chatMessage);
    this.messageInput = '';
  }

  lisenerMessage() {
    this.chatService.getMessageSubject().subscribe((messages: any) => {
      this.messageList = messages.map((item: any)=> ({
        ...item,
        message_side: item.user === this.userId ? 'sender': 'receiver'
      }))
    });
  }
 
}
  

