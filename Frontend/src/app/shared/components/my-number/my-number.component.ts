import { Component, ElementRef, inject, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { Observable } from 'rxjs';
import { NumberStateService } from 'src/app/core/service/number-state.service';

@Component({
  selector: 'app-my-number',
  templateUrl: './my-number.component.html',
  styleUrls: ['./my-number.component.scss']
})
export class MyNumberComponent {
  private numberStateService = inject(NumberStateService);

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
  userId: string = "";
  messageList: any[] = [];

  constructor(
  ) {
    this.result$ = this.numberStateService.getResult();
  }
}


