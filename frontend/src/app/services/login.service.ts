import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  isAuth = false;
  private baseEndPoint = 'http://localhost:8080/api/v1/auth/authenticate'
  constructor(private http: HttpClient, private router: Router) { }
  authenticate(body: any) {
    return this.http.post(this.baseEndPoint, body);
  }
  isAuthenticated() {
    if (localStorage.getItem('token')!.length > 0) this.isAuth = true;
    else this.isAuth = false;
    return this.isAuth;
  }
  handleToken(token: string, role: string, email: string) {
    localStorage.setItem('token', token);
    localStorage.setItem('role', role);
    localStorage.setItem('email', email);
    this.isAuth = true;
    if (role == 'ROLE_SUPERVISOR') {
      this.router.navigate(['/dashboard/supervisor']);
    } else if (role == 'ROLE_PASSENGER') {
      this.router.navigate(['/dashboard/pasajero']);
    } else {
      this.router.navigate(['/dashboard/agente']);
    }
  }
  getEmail() {
    return localStorage.getItem('email');
  }

  getRole() {
    return localStorage.getItem('role');
  }

  getToken() {
    return localStorage.getItem('token');
  }

  logOut() {
    localStorage.setItem('token', '');
    localStorage.setItem('role', '');
    this.isAuth = false;
    this.router.navigate(['/login']);
  }
}
