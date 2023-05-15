import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create.pasajero',
  templateUrl: './create.pasajero.component.html',
  styleUrls: ['./create.pasajero.component.scss']
})
export class CreatePasajeroComponent {
  title: string = 'Registrar';
  id: number = 0;
  passengerForm = new FormGroup({
    first_name: new FormControl('', Validators.required),
    second_name: new FormControl('', Validators.required),
    last_name: new FormControl('', Validators.required),
    phone_number: new FormControl('', Validators.required),
    email_address: new FormControl('', Validators.required),
    city: new FormControl('', Validators.required),
    country: new FormControl('', Validators.required),
    other_details: new FormControl('', Validators.required),
  });
  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    if (this.id != 0) {
      this.title = 'Editar';
    }
  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
