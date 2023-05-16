import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CreateReserva } from 'src/app/models/create/createReserva';
import { Escala } from 'src/app/models/escala';
import { Pasajero } from 'src/app/models/pasajero';
import { EscalaService } from 'src/app/services/escala.service';
import { PasajeroService } from 'src/app/services/pasajero.service';
import { ReservaService } from 'src/app/services/reserva.service';

@Component({
  selector: 'app-create.reserva',
  templateUrl: './create.reserva.component.html',
  styleUrls: ['./create.reserva.component.scss']
})
export class CreateReservaComponent {
  title: string = 'Registrar';
  id: number = 0;
  bookingForm!: FormGroup;
  passengers!: Pasajero[];
  legs!: Escala[];
  types = [
    { "role": "SEGUNDA_CLASE" },
    { "role": "EJECUTIVO" },
    { "role": "PRIMERA_CLASE" },
  ]

  constructor(private router: Router, private route: ActivatedRoute, private reservaService: ReservaService, private pasajeroService: PasajeroService,
    private escalaService: EscalaService) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.pasajeroService.getPassengersList().subscribe(data => {
      this.passengers = data;
    });
    this.escalaService.getLegs().subscribe(data => {
      this.legs = data;
    });
    this.bookingForm = new FormGroup({
      passenger_id: new FormControl('', Validators.required),
      travel_type_class: new FormControl('', Validators.required),
      number_in_party: new FormControl('', Validators.required),
      leg_id: new FormControl('', Validators.required)
    });
    if (this.id != 0) {
      this.title = 'Editar';
      this.reservaService.getReservationById(this.id).subscribe((data: any) => {
        console.log(data);
        this.bookingForm.get('passenger_id')?.setValue(data.passenger.passenger_id);
        this.bookingForm.get('travel_type_class')?.setValue(data.travel_type_class);
        this.bookingForm.get('number_in_party')?.setValue(data.number_in_party);
        this.bookingForm.get('leg_id')?.setValue(data.leg.leg_id);
      });
    }
  }
  
  public createReservation() {
    if (this.bookingForm.valid) {
      var body = new CreateReserva();
      var updateBody = new CreateReserva();
      body.agent_id = 1;
      body.passenger_id = this.bookingForm.get('passenger_id')?.value;
      body.travel_type_class = this.bookingForm.get('travel_type_class')?.value;
      body.number_in_party = this.bookingForm.get('number_in_party')?.value;
      body.leg_id = this.bookingForm.get('leg_id')?.value;
      if (this.id != 0) {
        updateBody.agent_id = 1;
        updateBody.passenger_id = this.bookingForm.get('passenger_id')?.value;
        updateBody.travel_type_class = this.bookingForm.get('travel_type_class')?.value;
        updateBody.number_in_party = this.bookingForm.get('number_in_party')?.value;
        updateBody.leg_id = this.bookingForm.get('leg_id')?.value;
        this.reservaService.updateReservation(this.id, updateBody).subscribe((data: any) => {
          this.redirectTo('dashboard/agente');
        });
      } else {
        this.reservaService.createReservation(body).subscribe((data: any) => {
          this.redirectTo('dashboard/agente');
        });
      }
    }
  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
