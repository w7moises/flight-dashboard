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
    let route = '';
    if (this.loginForm.valid) {
      let user = {
        email: this.loginForm.get('email')?.value,
        password: this.loginForm.get('password')?.value,
      };
      route = this.loginService.login(user.email!);
    }
    console.log(this.loginForm.value);
    this.router.navigate(['/dashboard/' + route]);
  }
}
