import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard.aereopuertos',
  templateUrl: './dashboard.aereopuertos.component.html',
  styleUrls: ['./dashboard.aereopuertos.component.scss']
})
export class DashboardAereopuertosComponent {
  role: string = '';
  title: string = 'aereopuertos';
  paths: string[] = ['Dashboard', 'Concepto de Aereopuertos'];
  data: string = 'supervisor/aereopuertos';

  constructor(private router: Router) {}

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
