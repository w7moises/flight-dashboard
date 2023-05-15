import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agente } from '../models/agente';

@Injectable({
  providedIn: 'root'
})
export class AgenteService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getAgentes() {
    return this.http.get(`${this.baseEndPoint}/agentes`);
  }

  public getAgente(id: number) {
    return this.http.get(`${this.baseEndPoint}/agentes/${id}`);
  }

  public createAgente(agente: Agente) {
    return this.http.post(`${this.baseEndPoint}/agentes`, agente);
  }

  public updateAgente(id: number, agente: Agente) {
    return this.http.put(`${this.baseEndPoint}/agentes/${id}`, agente);
  }

  public deleteAgente(id: number) {
    return this.http.delete(`${this.baseEndPoint}/agentes/${id}`);
  }
  
}
