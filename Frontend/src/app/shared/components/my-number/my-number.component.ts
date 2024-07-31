import { Component, ElementRef, inject, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { Observable } from 'rxjs';
import { NumberStateService } from 'src/app/core/service/number-state.service';
import { WebSocketService } from 'src/app/core/service/web-socket.service';

@Component({
  selector: 'app-my-number',
  templateUrl: './my-number.component.html',
  styleUrls: ['./my-number.component.scss']
})
export class MyNumberComponent {
  private numberStateService = inject(NumberStateService);
  private webSocketService = inject(WebSocketService);

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

  constructor() {
    this.result$ = this.numberStateService.getResult();
  }

  ngOnInit(): void {
    this.webSocketService.getMessages().subscribe(message => {
      console.log('Received message:', message);
      this.handleReceivedMessage(message);
    });
  }

  sendMessage(message: any): void {
    this.webSocketService.sendMessage(message);
  }

  handleReceivedMessage(message: any): void {
    alert(message);
  }

  compareResults() {
    this.result$.subscribe(result => {
      if (result !== undefined) {
        const player1Difference = Math.abs(this.playerResults[0] - result);
        const player2Difference = Math.abs(this.playerResults[1] - result);

        if (player1Difference < player2Difference) {
          this.sendMessage('Igrač 1 je pobednik!');
        } else if (player2Difference < player1Difference) {
          this.sendMessage('Igrač 2 je pobednik!');
        } else {
          this.sendMessage('Nerešeno!');
        }
      }
    });
  }

  nextPlayer(): void {
    this.currentPlayer = this.currentPlayer === 1 ? 2 : 1;
  }

  checkResult(playerResult: number) {
    this.playerResults[this.currentPlayer - 1] = playerResult;
    if (this.currentPlayer === 2) {
     this.compareResults();
    } else {
      this.nextPlayer();
    }
  }
  parseValue(value: string): number {
    return parseInt(value, 10);
  }
 
}
  

