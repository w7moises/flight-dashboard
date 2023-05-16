import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pasajero } from '../models/pasajero';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class PasajeroService {
  private baseEndPoint = 'http://localhost:8080/api/v1';
  token: string = '';

  constructor(private http: HttpClient, private loginService: LoginService) {
    if (this.loginService.getToken() != null) {
      this.token = 'Bearer ' + loginService.getToken();
    }
  }

  public getPassengers(page: string, size: string): Observable<any> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<any>(`${this.baseEndPoint}/pasajeros/page`, { params: params, headers: corsHeaders });
  }
  public getPassengersList(): Observable<Pasajero[]> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Pasajero[]>(`${this.baseEndPoint}/pasajeros`, { headers: corsHeaders });
  }
  public getPassengerById(id: number): Observable<Pasajero> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Pasajero>(`${this.baseEndPoint}/pasajeros/${id}`, { headers: corsHeaders });
  }

  public createPassenger(pasajero: Pasajero): Observable<Pasajero> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.post<Pasajero>(`${this.baseEndPoint}/pasajeros`, pasajero, { headers: corsHeaders });
  }

  public updatePassenger(id: number, pasajero: Pasajero): Observable<Pasajero> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.put<Pasajero>(`${this.baseEndPoint}/pasajeros/${id}`, pasajero, { headers: corsHeaders });
  }

  public deletePassenger(id: number): Observable<Pasajero> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.delete<Pasajero>(`${this.baseEndPoint}/pasajeros/${id}`, { headers: corsHeaders });
  }
}
