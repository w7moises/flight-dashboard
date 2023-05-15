import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard.vuelos',
  templateUrl: './dashboard.vuelos.component.html',
  styleUrls: ['./dashboard.vuelos.component.scss']
})
export class DashboardVuelosComponent {
  role: string = '';
  title: string = 'vuelos';
  paths: string[] = ['Dashboard', 'Concepto de Vuelos'];
  data: string = 'supervisor/vuelos';

  constructor(private router: Router) {}

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
