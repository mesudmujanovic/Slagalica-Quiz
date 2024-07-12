import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ScoreService {

  userScore: number = 0;

  constructor() { }

  addToScore(score: number): void {
    this.userScore += score;
  }

  getScore(){
    return this.userScore;
  }
}
