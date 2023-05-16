import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

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

  constructor(private router: Router, private loginService: LoginService) { }

  login() {
    if (this.loginForm.valid) {
      let user = {
        email: this.loginForm.get('email')?.value,
        password: this.loginForm.get('password')?.value,
      };
      this.loginService.authenticate(user).subscribe((data: any) => {
        this.loginService.handleToken(data.token, data.role, user.email!);
      });
    }
    return;
  }
}
