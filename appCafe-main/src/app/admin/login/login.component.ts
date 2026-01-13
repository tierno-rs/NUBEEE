import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../services/user.service'; 
import { AlertService } from '../../shared/data-access/alert.service';

@Component({
  selector: 'app-login',
  imports: [RouterLink, ReactiveFormsModule, CommonModule],
  templateUrl: './login.component.html',
  standalone: true,
  styleUrl: './login.component.css'
})
export class LoginComponent {
  private userService = inject(UserService);
  private alertService = inject(AlertService);
  private router = inject(Router);

  loginForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  get email() { return this.loginForm.get('email')!; }
  get password() { return this.loginForm.get('password')!; }

  onSubmit() {
    if (this.loginForm.invalid) return;

    const { email, password } = this.loginForm.value;

    this.userService.login(email, password).subscribe({
      next: (response) => {
        // Mostramos la notificación de éxito
        this.alertService.toast('Login exitoso');
        
        // CORRECCIÓN IMPLEMENTADA: 
        // Navegamos a '/page/dashboard' en singular para coincidir con app.routes.ts
        this.router.navigate(['/page/dashboard']); 
      },
      error: (error) => {
        console.error('Error en el login:', error);
        this.alertService.toast('Error en los datos', 'error');
      }
    });
  }
}