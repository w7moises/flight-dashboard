import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseEndPoint = 'http://localhost:8080/api/login';
  constructor() { }

  public login(role: string): string{
    return role == 'supervisor' ? 'supervisor' : role == 'agente' ? 'agente' : 'pasajero';
  }
}
