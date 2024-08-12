import { Component, inject, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject, catchError, takeUntil, tap } from 'rxjs';
import { AuthService } from 'src/app/core/service/auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  private authService = inject(AuthService);
  private destroy$ = new Subject<void>();
  authForm!: FormGroup;
  isSubmitted = false;
  isLoginMode = true;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.authForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(4)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  get formControls() {
    return this.authForm.controls;
  }

  switchMode(): void {
    this.isLoginMode = !this.isLoginMode;
  }

  onSubmit(): void {
    this.isSubmitted = true;
    if (this.authForm.invalid) {
      return;
    }

    const { username, password } = this.authForm.value;

    const request$ = this.isLoginMode 
    ? this.authService.login(username, password) 
    : this.authService.signup(username, password);

    request$.pipe(
      tap((response) => {
        if (this.isLoginMode) {
          console.log('Login successful', response);
        } else {
          console.log('Signup successful', response);
          this.isLoginMode = true;
        }
      }),
      catchError((error) => {
        if (this.isLoginMode) {
          console.error('Login failed', error);
        } else {
          console.error('Signup failed', error);
        }
        return []; 
      }),
      takeUntil(this.destroy$)
    ).subscribe(); 
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
