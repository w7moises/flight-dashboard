import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Pasajero } from 'src/app/models/pasajero';

@Component({
  selector: 'app-dashboard.pasajeros',
  templateUrl: './dashboard.pasajeros.component.html',
  styleUrls: ['./dashboard.pasajeros.component.scss']
})
export class DashboardPasajerosComponent {
  role: string = '';
  title: string = 'pasajeros';
  paths: string[] = ['Dashboard', 'Concepto de Pasajeros'];
  data: string = 'agente/pasajero';

  constructor(private router: Router) {}

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
  
}
