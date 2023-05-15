import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Aereopuerto } from '../models/aereopuerto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AereopuertoService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getAirports(page: string, size: string): Observable<any> {
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get(`${this.baseEndPoint}/aereopuertos/page`, { params: params });
  }

  public getAirportById(id: number): Observable<Aereopuerto> {
    return this.http.get<Aereopuerto>(`${this.baseEndPoint}/aereopuertos/${id}`);
  }

  public createAirport(aereopuerto: Aereopuerto): Observable<Aereopuerto> {
    return this.http.post<Aereopuerto>(`${this.baseEndPoint}/aereopuertos`, aereopuerto);
  }

  public updateAirport(id: number, aereopuerto: Aereopuerto): Observable<Aereopuerto> {
    return this.http.put<Aereopuerto>(`${this.baseEndPoint}/aereopuertos/${id}`, aereopuerto);
  }

  public deleteAirport(id: number): Observable<Aereopuerto> {
    return this.http.delete<Aereopuerto>(`${this.baseEndPoint}/aereopuertos/${id}`);
  }

}
