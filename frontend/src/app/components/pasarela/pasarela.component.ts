import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pasarela',
  templateUrl: './pasarela.component.html',
  styleUrls: ['./pasarela.component.scss']
})
export class PasarelaComponent {
  @Input() paths: string[] = [];
  @Input() title: string = '';

  constructor(private router: Router) {}

  public return() {
    this.router.navigate(['dashboard/pasajero']);
  }
}
