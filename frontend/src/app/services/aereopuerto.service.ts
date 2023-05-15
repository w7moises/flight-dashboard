import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Aereopuerto } from '../models/aereopuerto';

@Injectable({
  providedIn: 'root'
})
export class AereopuertoService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getAereopuertos() {
    return this.http.get(`${this.baseEndPoint}/aereopuertos`);
  }

  public getAereopuerto(id: number) {
    return this.http.get(`${this.baseEndPoint}/aereopuertos/${id}`);
  }

  public createAereopuerto(aereopuerto: Aereopuerto) {
    return this.http.post(`${this.baseEndPoint}/aereopuertos`, aereopuerto);
  }

  public updateAereopuerto(id: number, aereopuerto: Aereopuerto) {
    return this.http.put(`${this.baseEndPoint}/aereopuertos/${id}`, aereopuerto);
  }

  public deleteAereopuerto(id: number) {
    return this.http.delete(`${this.baseEndPoint}/aereopuertos/${id}`);
  }

}
