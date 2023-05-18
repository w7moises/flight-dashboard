import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Aereopuerto } from '../models/aereopuerto';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AereopuertoService {
  private baseEndPoint = 'http://localhost:8080/api/v1'
  token: string = '';

  constructor(private http: HttpClient, private loginService: LoginService) {
    if (this.loginService.getToken() != null) {
      this.token = 'Bearer ' + loginService.getToken();
    }
  }

  public getAirports(page: string, size: string): Observable<any> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get(`${this.baseEndPoint}/aereopuertos/page`, { params: params, headers: corsHeaders });
  }

  public getAirportsList(): Observable<Aereopuerto[]> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Aereopuerto[]>(`${this.baseEndPoint}/aereopuertos`, { headers: corsHeaders });
  }

  public getAirportById(id: number): Observable<Aereopuerto> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Aereopuerto>(`${this.baseEndPoint}/aereopuertos/${id}`, { headers: corsHeaders });
  }

  public createAirport(aereopuerto: Aereopuerto): Observable<Aereopuerto> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.post<Aereopuerto>(`${this.baseEndPoint}/aereopuertos`, aereopuerto, { headers: corsHeaders });
  }

  public updateAirport(id: number, aereopuerto: Aereopuerto): Observable<Aereopuerto> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.put<Aereopuerto>(`${this.baseEndPoint}/aereopuertos/${id}`, aereopuerto, { headers: corsHeaders });
  }

  public deleteAirport(id: number): Observable<Aereopuerto> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.delete<Aereopuerto>(`${this.baseEndPoint}/aereopuertos/${id}`, { headers: corsHeaders });
  }

}
