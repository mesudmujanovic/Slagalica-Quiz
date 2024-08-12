import { Component, inject } from '@angular/core';
import { map, Observable, ObservedValueOf } from 'rxjs';
import { LetterWord } from 'src/app/core/interface/LetterWord-interface';
import { LetterWordService } from 'src/app/core/service/letter-word.service';

@Component({
  selector: 'app-letter-word',
  templateUrl: './letter-word.component.html',
  styleUrls: ['./letter-word.component.scss']
})
export class LetterWordComponent {

  private letterWordService = inject(LetterWordService);
  letterWord: LetterWord;

  constructor() { }


  ngOnInit() {
  }
}