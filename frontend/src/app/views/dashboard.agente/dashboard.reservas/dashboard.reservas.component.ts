import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard.reservas',
  templateUrl: './dashboard.reservas.component.html',
  styleUrls: ['./dashboard.reservas.component.scss']
})
export class DashboardReservasComponent {
  role: string = '';
  title: string = 'reservas';
  paths: string[] = ['Dashboard', 'Concepto de reservas'];
  data: string = 'agente';

  constructor(private router: Router) {}

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
  
}
