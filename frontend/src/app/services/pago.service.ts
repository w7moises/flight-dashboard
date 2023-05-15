import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pago } from '../models/pago';

@Injectable({
  providedIn: 'root'
})
export class PagoService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getPagos() {
    return this.http.get(`${this.baseEndPoint}/pagos`);
  }

  public getPago(id: number) {
    return this.http.get(`${this.baseEndPoint}/pagos/${id}`);
  }

  public createPago(pago: Pago) {
    return this.http.post(`${this.baseEndPoint}/pagos`, pago);
  }

  public updatePago(id: number, pago: Pago) {
    return this.http.put(`${this.baseEndPoint}/pagos/${id}`, pago);
  }

  public deletePago(id: number) {
    return this.http.delete(`${this.baseEndPoint}/pagos/${id}`);
  }
}
