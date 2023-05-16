import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agente } from '../models/agente';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AgenteService {
  private baseEndPoint = 'http://localhost:8080/api/v1'
  token: string = '';

  constructor(private http: HttpClient, private loginService: LoginService) {
    if (this.loginService.getToken() != null) {
      this.token = 'Bearer ' + loginService.getToken();
    }
  }

  public getAgents(page: string, size: string): Observable<any> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<any>(`${this.baseEndPoint}/agentes/page`, { params: params, headers: corsHeaders });
  }

  public getAgentById(id: number): Observable<Agente> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.get<Agente>(`${this.baseEndPoint}/agentes/${id}`, { headers: corsHeaders });
  }

  public createAgent(agente: Agente): Observable<Agente> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.post<Agente>(`${this.baseEndPoint}/agentes`, agente, { headers: corsHeaders });
  }

  public updateAgent(id: number, agente: Agente): Observable<Agente> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.put<Agente>(`${this.baseEndPoint}/agentes/${id}`, agente, { headers: corsHeaders });
  }

  public deleteAgent(id: number): Observable<Agente> {
    let corsHeaders = new HttpHeaders({
      Authorization: this.token,
    });
    return this.http.delete<Agente>(`${this.baseEndPoint}/agentes/${id}`, { headers: corsHeaders });
  }
}
