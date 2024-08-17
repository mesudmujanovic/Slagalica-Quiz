import { Injectable } from '@angular/core';
import { finalize, interval, takeUntil, tap, timer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TimeService {

  startTimer(duration: number, updateFn: (counter: number) => void, completeFn: () => void) {
    const stopAfterDuration$ = timer(duration);
    let counter = duration / 1000;
    return interval(1000).pipe(
      takeUntil(stopAfterDuration$),
      tap(() => {
        updateFn(counter);
        counter--;
      }),
      finalize(completeFn)
    );
  }
}
