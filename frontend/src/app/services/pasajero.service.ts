import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pasajero } from '../models/pasajero';

@Injectable({
  providedIn: 'root'
})
export class PasajeroService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getPasajeros() {
    return this.http.get(`${this.baseEndPoint}/pasajeros`);
  }

  public getPasajero(id: number) {
    return this.http.get(`${this.baseEndPoint}/pasajeros/${id}`);
  }

  public createPasajero(pasajero: Pasajero) {
    return this.http.post(`${this.baseEndPoint}/pasajeros`, pasajero);
  }

  public updatePasajero(id: number, pasajero: Pasajero) {
    return this.http.put(`${this.baseEndPoint}/pasajeros/${id}`, pasajero);
  }

  public deletePasajero(id: number) {
    return this.http.delete(`${this.baseEndPoint}/pasajeros/${id}`);
  }
}
