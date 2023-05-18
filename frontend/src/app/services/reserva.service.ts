import { Injectable } from '@angular/core';
import { Reserva } from '../models/reserva';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { LoginService } from './login.service';
import { Observable } from 'rxjs';
import { CreateReserva } from '../models/create/createReserva';
import { Aereolinea } from '../models/aereolinea';
import { Avion } from '../models/avion';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {
  private baseEndPoint = 'http://localhost:8080/api/v1';
  token: string = '';


  constructor(private http: HttpClient, private loginService: LoginService) {
    if (this.loginService.getToken() != null) {
      this.token = 'Bearer ' + loginService.getToken();
    }
  }

  public getReservations(page: string, size: string): Observable<any> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<any>(`${this.baseEndPoint}/reservas/page`, { params: params, headers: corsHeaders });
  }

  public getAirlines(): Observable<Aereolinea[]> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Aereolinea[]>(`${this.baseEndPoint}/aereolineas`, { headers: corsHeaders });
  }

  public getAircraft(): Observable<Avion[]> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Avion[]>(`${this.baseEndPoint}/aviones`, { headers: corsHeaders });
  }

  public getReservationById(id: number): Observable<Reserva> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Reserva>(`${this.baseEndPoint}/reservas/${id}`, { headers: corsHeaders });
  }

  public getReservationsByEmail(email: string): Observable<any> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<any>(`${this.baseEndPoint}/reservas/email/${email}`, { headers: corsHeaders });
  }

  public createReservation(reserva: CreateReserva): Observable<Reserva> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.post<Reserva>(`${this.baseEndPoint}/reservas`, reserva, { headers: corsHeaders });
  }

  public updateReservation(id: number, reserva: CreateReserva): Observable<Reserva> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.put<Reserva>(`${this.baseEndPoint}/reservas/${id}`, reserva, { headers: corsHeaders });
  }

  public deleteReservation(id: number): Observable<Reserva> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.delete<Reserva>(`${this.baseEndPoint}/reservas/${id}`, { headers: corsHeaders });
  }
}
