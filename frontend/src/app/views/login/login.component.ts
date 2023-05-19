import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  constructor(private router: Router, private loginService: LoginService, private snackBar: MatSnackBar) { }

  login() {
    if (this.loginForm.valid) {
      let user = {
        email: this.loginForm.get('email')?.value,
        password: this.loginForm.get('password')?.value,
      };
      this.loginService.authenticate(user).subscribe((data: any) => {
        this.loginService.handleToken(data.token, data.role, user.email!);
      });
    } else {
      this.snackBar.open(
        'Rellenar todos los campos',
        '',
        {
          duration: 3000,
          panelClass: ['red-snackbar'],
        }
      );
    }
    return;
  }
}
