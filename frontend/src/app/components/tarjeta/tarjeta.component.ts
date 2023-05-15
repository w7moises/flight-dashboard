import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tarjeta',
  templateUrl: './tarjeta.component.html',
  styleUrls: ['./tarjeta.component.scss']
})
export class TarjetaComponent {
   options: number = 0;

   constructor(private router: Router) {}

   public changeOption(option: number) {
      this.options = option;
      console.log(this.options);
   }

   pay (){
     this.router.navigate(['/dashboard/pasajero']);
   }
}
