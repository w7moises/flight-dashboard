import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreateVuelo } from '../models/create/createVuelo';
import { LoginService } from './login.service';
import { Vuelo } from '../models/vuelo';

@Injectable({
  providedIn: 'root'
})
export class VueloService {
  private baseEndPoint = 'http://localhost:8080/api/v1';
  token: string = '';


  constructor(private http: HttpClient, private loginService: LoginService) {
    if (this.loginService.getToken() != null) {
      this.token = 'Bearer ' + loginService.getToken();
    }
  }

  public getFlights(page: string, size: string): Observable<any> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<any>(`${this.baseEndPoint}/vuelos/page`, { params: params, headers: corsHeaders });
  }

  public getFlightById(id: number): Observable<Vuelo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Vuelo>(`${this.baseEndPoint}/vuelos/${id}`, { headers: corsHeaders });
  }

  public createFlight(Vuelo: CreateVuelo): Observable<Vuelo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.post<Vuelo>(`${this.baseEndPoint}/vuelos`, Vuelo, { headers: corsHeaders });
  }

  public updateFlight(id: number, Vuelo: CreateVuelo): Observable<Vuelo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.put<Vuelo>(`${this.baseEndPoint}/vuelos/${id}`, Vuelo, { headers: corsHeaders });
  }

  public deleteFlight(id: number): Observable<Vuelo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.delete<Vuelo>(`${this.baseEndPoint}/vuelos/${id}`, { headers: corsHeaders });
  }
}
