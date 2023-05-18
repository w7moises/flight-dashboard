import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreateCosto } from '../models/create/createCosto';
import { Costo } from '../models/costo';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class CostoService {
  private baseEndPoint = 'http://localhost:8080/api/v1';
  token: string = '';


  constructor(private http: HttpClient, private loginService: LoginService) {
    if (this.loginService.getToken() != null) {
      this.token = 'Bearer ' + loginService.getToken();
    }
  }

  public getCostsByFlightId(id: number): Observable<Costo[]> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Costo[]>(`${this.baseEndPoint}/costos/vuelo/${id}`, { headers: corsHeaders });
  }


  public getCostsById(id: number): Observable<Costo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Costo>(`${this.baseEndPoint}/costos/${id}`, { headers: corsHeaders });
  }

  public createCost(costo: CreateCosto): Observable<Costo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.post<Costo>(`${this.baseEndPoint}/costos`, costo, { headers: corsHeaders });
  }

  public updateCost(id: number, Costo: CreateCosto): Observable<Costo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.put<Costo>(`${this.baseEndPoint}/costos/${id}`, Costo, { headers: corsHeaders });
  }

  public deleteCost(id: number): Observable<Costo> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.delete<Costo>(`${this.baseEndPoint}/costos/${id}`, { headers: corsHeaders });
  }
}
