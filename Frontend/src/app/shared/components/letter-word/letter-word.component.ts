import { ChangeDetectorRef, Component, ElementRef, inject, QueryList, Renderer2, ViewChild, ViewChildren } from '@angular/core';
import { map, tap } from 'rxjs';
import { LetterWord } from 'src/app/core/interface/LetterWord-interface';
import { LetterWordService } from 'src/app/core/service/letter-word.service';
import { NumberStateService } from 'src/app/core/service/number-state.service';

@Component({
  selector: 'app-letter-word',
  templateUrl: './letter-word.component.html',
  styleUrls: ['./letter-word.component.scss']
})
export class LetterWordComponent {

  @ViewChildren('numDiv') numDivs: QueryList<ElementRef>;
  @ViewChild('containerCalc') containerCalc: ElementRef | undefined;
  letters: (string | undefined)[] = [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined];

  currentDivIndex: number = 1;
  public counter: number = 60;
  public toShow: string;
  public counterButton: number = 0;
  constructor(private letterWordService: LetterWordService) { }

  // ngAfterViewInit() {
  //   this.letterWordService.getRandomLetterWord().subscribe(letterWord => {
  //     if (letterWord.letters) {
  //       this.letters = letterWord.letters;
  //       console.log(this.letters);
  //       this.letterDivs.forEach((div, i) => {
  //         console.log(`${i + 1}`, div.nativeElement.textContent);
  //       })
  //     }
  //   });
  // }



  ngOnInit() {

  }
}