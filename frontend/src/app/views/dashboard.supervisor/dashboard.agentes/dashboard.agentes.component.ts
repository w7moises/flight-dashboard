import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard.agentes',
  templateUrl: './dashboard.agentes.component.html',
  styleUrls: ['./dashboard.agentes.component.scss']
})
export class DashboardAgentesComponent {
  role: string = '';
  title: string = 'agentes';
  paths: string[] = ['Dashboard', 'Concepto de Agentes'];
  data: string = 'supervisor';

  constructor(private router: Router) {}

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
