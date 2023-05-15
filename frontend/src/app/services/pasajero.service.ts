import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pasajero } from '../models/pasajero';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PasajeroService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getPassengers(page: string, size: string): Observable<any> {
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<any>(`${this.baseEndPoint}/pasajeros/page`, { params: params });
  }

  public getPassengerById(id: number): Observable<Pasajero> {
    return this.http.get<Pasajero>(`${this.baseEndPoint}/pasajeros/${id}`);
  }

  public createPassenger(pasajero: Pasajero): Observable<Pasajero> {
    return this.http.post<Pasajero>(`${this.baseEndPoint}/pasajeros`, pasajero);
  }

  public updatePassenger(id: number, pasajero: Pasajero): Observable<Pasajero> {
    return this.http.put<Pasajero>(`${this.baseEndPoint}/pasajeros/${id}`, pasajero);
  }

  public deletePassenger(id: number): Observable<Pasajero> {
    return this.http.delete<Pasajero>(`${this.baseEndPoint}/pasajeros/${id}`);
  }
}
