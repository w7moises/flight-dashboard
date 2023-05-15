import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard.pasajero',
  templateUrl: './dashboard.pasajero.component.html',
  styleUrls: ['./dashboard.pasajero.component.scss']
})
export class DashboardPasajeroComponent {
  title: string = 'pagos';
  paths: string[] = ['Dashboard', 'Concepto de Pagos'];
  data: string = 'pasajero';
  state: boolean = false;
  
  constructor(private router: Router) { }

  ngOnInit(): void {

  }

}
