import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PasajeroService } from 'src/app/services/pasajero.service';
import { Pasajero } from 'src/app/models/pasajero';

@Component({
  selector: 'app-create.pasajero',
  templateUrl: './create.pasajero.component.html',
  styleUrls: ['./create.pasajero.component.scss']
})
export class CreatePasajeroComponent {
  title: string = 'Registrar';
  id: number = 0;
  passengerForm!: FormGroup;

  constructor(private router: Router, private route: ActivatedRoute, private service: PasajeroService) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.passengerForm = new FormGroup({
      first_name: new FormControl('', Validators.required),
      second_name: new FormControl('', Validators.required),
      last_name: new FormControl('', Validators.required),
      phone_number: new FormControl('', Validators.required),
      email_address: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      country: new FormControl('', Validators.required),
      other_details: new FormControl('', Validators.required),
    });

    if (this.id != 0) {
      this.title = 'Editar';
      this.service.getPassengerById(this.id).subscribe((data: any) => {
        this.passengerForm.get('first_name')?.setValue(data.firstName);
        this.passengerForm.get('second_name')?.setValue(data.secondName);
        this.passengerForm.get('last_name')?.setValue(data.lastName);
        this.passengerForm.get('phone_number')?.setValue(data.phoneNumber);
        this.passengerForm.get('email_address')?.setValue(data.emailAddress);
        this.passengerForm.get('city')?.setValue(data.city);
        this.passengerForm.get('country')?.setValue(data.country);
        this.passengerForm.get('other_details')?.setValue(data.otherDetails);
      });
    }
  }

  public createPassenger() {
    if (this.passengerForm.valid) {
      var body = new Pasajero();
      var updateBody = new Pasajero();
      body.firstName = this.passengerForm.get('first_name')?.value;
      body.secondName = this.passengerForm.get('second_name')?.value;
      body.lastName = this.passengerForm.get('last_name')?.value;
      body.phoneNumber = this.passengerForm.get('phone_number')?.value;
      body.emailAddress = this.passengerForm.get('email_address')?.value;
      body.city = this.passengerForm.get('city')?.value;
      body.country = this.passengerForm.get('country')?.value;
      body.otherDetails = this.passengerForm.get('other_details')?.value;

      if (this.id != 0) {
        updateBody.firstName = this.passengerForm.get('first_name')?.value;
        updateBody.secondName = this.passengerForm.get('second_name')?.value;
        updateBody.lastName = this.passengerForm.get('last_name')?.value;
        updateBody.phoneNumber = this.passengerForm.get('phone_number')?.value;
        updateBody.emailAddress = this.passengerForm.get('email_address')?.value;
        updateBody.city = this.passengerForm.get('city')?.value;
        updateBody.country = this.passengerForm.get('country')?.value;
        updateBody.otherDetails = this.passengerForm.get('other_details')?.value;
        this.service.updatePassenger(this.id, updateBody).subscribe((data: any) => { this.redirectTo('dashboard/agente/pasajero'); });
      } else {
        this.service.createPassenger(body).subscribe((data: any) => { this.redirectTo('dashboard/agente/pasajero'); });
      }
    }
  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
