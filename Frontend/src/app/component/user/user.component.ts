import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, catchError, map, of, switchMap, tap } from 'rxjs';
import { User } from 'src/app/interface/User-Interface';
import { ScoreService } from 'src/app/service/score.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  public users$: Observable<User[]>
  userScore = this.scoreService.getScore();
  userForm: FormGroup
  constructor(private scoreService: ScoreService,
    private formBuilder: FormBuilder,
    private userService: UserService) {
    this.userForm = this.formBuilder.group({
      username: ['', Validators.required]
    })
  }

  sortUsersByScoreDesc() {
    this.users$ = this.users$.pipe(
      map(users => users.sort((a, b) => a.userscore - b.userscore))
    );
  }
  
  

  sortUsersByScoreAsc() {
    this.users$ = this.users$.pipe(
      map(users => users.sort((a, b) => b.userscore - a.userscore))
    );
  }
  

  onUser() {
    if (this.userForm.valid) {
      const userscore = this.scoreService.getScore();
      const username = this.userForm.get('username')?.value;
      this.userService.addUser(userscore, username).pipe(
        switchMap(() => this.allUsers()),
        tap(response => {
          console.log("ukupno", userscore, "username", username);
        })
      ).subscribe(() => {
        console.log("subscribe");
      })
    }
  }

  allUsers(): Observable<User[]> {
    return this.users$ = this.userService.allUsers().pipe(
      catchError(error => {
        console.log("error", error);
        return of([]);
      })
    )
  }

  ngOnInit() {
    console.log("userscore", this.userScore);

    this.allUsers().subscribe(
      users => {
        console.log(users);
      }
    );
  }
}
