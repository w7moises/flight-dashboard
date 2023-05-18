import { Injectable } from '@angular/core';
import { Escala } from '../models/escala';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';
import { CreateEscala } from '../models/create/createEscala';

@Injectable({
  providedIn: 'root'
})
export class EscalaService {
  private baseEndPoint = 'http://localhost:8080/api/v1'
  token: string = '';

  constructor(private http: HttpClient, private loginService: LoginService) {
    if (this.loginService.getToken() != null) {
      this.token = 'Bearer ' + loginService.getToken();
    }
  }

  public getLegs(): Observable<Escala[]> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Escala[]>(`${this.baseEndPoint}/escalas`, { headers: corsHeaders });
  }

  public getLegById(id: number): Observable<Escala> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Escala>(`${this.baseEndPoint}/escalas/${id}`, { headers: corsHeaders });
  }

  public getLegByFlightId(id: number): Observable<Escala[]> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Escala[]>(`${this.baseEndPoint}/escalas/vuelo/${id}`, { headers: corsHeaders });
  }

  public createLeg(escala: CreateEscala): Observable<Escala> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.post<Escala>(`${this.baseEndPoint}/escalas`, escala, { headers: corsHeaders });
  }

  public updateLeg(id: number, escala: CreateEscala): Observable<Escala> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.put<Escala>(`${this.baseEndPoint}/escalas/${id}`, escala, { headers: corsHeaders });
  }

  public deleteLeg(id: number): Observable<Escala> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.delete<Escala>(`${this.baseEndPoint}/escalas/${id}`, { headers: corsHeaders });
  }
}
