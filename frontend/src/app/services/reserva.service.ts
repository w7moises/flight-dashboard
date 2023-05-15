import { Injectable } from '@angular/core';
import { Reserva } from '../models/reserva';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getReservas() {
    return this.http.get(`${this.baseEndPoint}/reservas`);
  }

  public getReserva(id: number) {
    return this.http.get(`${this.baseEndPoint}/reservas/${id}`);
  }

  public createReserva(reserva: Reserva) {
    return this.http.post(`${this.baseEndPoint}/reservas`, reserva);
  }

  public updateReserva(id: number, reserva: Reserva) {
    return this.http.put(`${this.baseEndPoint}/reservas/${id}`, reserva);
  }

  public deleteReserva(id: number) {
    return this.http.delete(`${this.baseEndPoint}/reservas/${id}`);
  }
}
