import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agente } from '../models/agente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgenteService {
  private baseEndPoint = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  public getAgents(page: string, size: string): Observable<any> {
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<any>(`${this.baseEndPoint}/agentes/page`, { params: params });
  }

  public getAgentById(id: number): Observable<Agente> {
    return this.http.get<Agente>(`${this.baseEndPoint}/agentes/${id}`);
  }

  public createAgent(agente: Agente): Observable<Agente> {
    return this.http.post<Agente>(`${this.baseEndPoint}/agentes`, agente);
  }

  public updateAgent(id: number, agente: Agente): Observable<Agente> {
    return this.http.put<Agente>(`${this.baseEndPoint}/agentes/${id}`, agente);
  }

  public deleteAgent(id: number): Observable<Agente> {
    return this.http.delete<Agente>(`${this.baseEndPoint}/agentes/${id}`);
  }

}
