import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { Form, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Aereolinea } from 'src/app/models/aereolinea';
import { Aereopuerto } from 'src/app/models/aereopuerto';
import { Avion } from 'src/app/models/avion';
import { AereopuertoService } from 'src/app/services/aereopuerto.service';
import { ReservaService } from 'src/app/services/reserva.service';
import { VueloService } from 'src/app/services/vuelo.service';
import { EscalaService } from '../../../services/escala.service';
import { Escala } from 'src/app/models/escala';
import { MatDialog } from '@angular/material/dialog';
import { ModalDeleteComponent } from 'src/app/components/modal.delete/modal.delete.component';
import { CreateEscala } from '../../../models/create/createEscala';
import { Costo } from 'src/app/models/costo';
import { CostoService } from '../../../services/costo.service';
import { CreateCosto } from 'src/app/models/create/createCosto';
import { CreateVuelo } from 'src/app/models/create/createVuelo';

@Component({
  selector: 'app-create.vuelo',
  templateUrl: './create.vuelo.component.html',
  styleUrls: ['./create.vuelo.component.scss']
})
export class CreateVueloComponent {
  title: string = 'Registrar';
  id: number = 0;
  leg_id: number = 0;
  cost_id: number = 0;
  temp_id: number = 0;
  airline_id: number = 0;
  flightForm!: FormGroup;
  legForm!: FormGroup;
  costForm!: FormGroup;
  airlines!: Aereolinea[];
  aircrafts!: Avion[];
  airports!: Aereopuerto[];
  legs!: Escala[];
  costs!: Costo[];
  departure_date = new FormControl;
  arrival_date = new FormControl;
  actual_departure_date = new FormControl;
  actual_arrival_date = new FormControl;
  valid_from_date = new FormControl;
  valid_to_date = new FormControl;
  constructor(private router: Router, private route: ActivatedRoute, private reservaService: ReservaService,
    private aereopuertoService: AereopuertoService, private datePipe: DatePipe, private vueloService: VueloService,
    private dialog: MatDialog, private escalaService: EscalaService, private costoService: CostoService) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.reservaService.getAirlines().subscribe(data => {
      this.airlines = data;
    });
    this.reservaService.getAircraft().subscribe(data => {
      this.aircrafts = data;
    });
    this.aereopuertoService.getAirportsList().subscribe(data => {
      this.airports = data;
    });
    this.escalaService.getLegByFlightId(this.id).subscribe(data => {
      this.legs = data;
    });
    this.costoService.getCostsByFlightId(this.id).subscribe(data => {
      this.costs = data;
    });
    this.flightForm = new FormGroup({
      airline_id: new FormControl('', Validators.required),
      aircraft_id: new FormControl('', Validators.required),
      origin_airport_id: new FormControl('', Validators.required),
      destination_airport_id: new FormControl('', Validators.required),
      departure_time: new FormControl('', Validators.required),
      arrival_time: new FormControl('', Validators.required),
    });
    this.legForm = new FormGroup({
      flight_id: new FormControl('', Validators.required),
      origin_airport_id: new FormControl('', Validators.required),
      destination_airport_id: new FormControl('', Validators.required),
      actual_departure_time: new FormControl('', Validators.required),
      actual_arrival_time: new FormControl('', Validators.required),
    });
    this.costForm = new FormGroup({
      airline_id: new FormControl('', Validators.required),
      flight_id: new FormControl('', Validators.required),
      flight_cost: new FormControl('', Validators.required),
    });
    if (this.id != 0) {
      this.title = 'Editar';
      this.vueloService.getFlightById(this.id).subscribe((data: any) => {
        var dateDepartureString = data.departureDate;
        var dateDepartureParts = dateDepartureString.split("-");
        var dateArrivalString = data.arrivalDate;
        var dateArrivalParts = dateArrivalString.split("-");
        this.flightForm.get('airline_id')?.setValue(data.airline.airline_id);
        this.flightForm.get('aircraft_id')?.setValue(data.airplane.aircraft_id);
        this.departure_date.setValue(new Date(+dateDepartureParts[2], dateDepartureParts[1] - 1, +dateDepartureParts[0]));
        this.arrival_date.setValue(new Date(+dateArrivalParts[2], dateArrivalParts[1] - 1, +dateArrivalParts[0]));
        this.flightForm.get('origin_airport_id')?.setValue(data.origin_airport.airportId);
        this.flightForm.get('destination_airport_id')?.setValue(data.destination_airport.airportId);
        this.flightForm.get('departure_time')?.setValue(data.departureTime);
        this.flightForm.get('arrival_time')?.setValue(data.arrivalTime);
      });
    }
  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }

  addCost() {
    console.log(this.datePipe.transform(this.departure_date.value, 'dd-MM-yyyy'));
    console.log(this.flightForm.value);
    console.log(this.legForm.value);
  }

  editLeg(id: number) {
    this.escalaService.getLegById(id).subscribe((data: any) => {
      var dateDepartureString = data.actualDepartureDate;
      var dateDepartureParts = dateDepartureString.split("-");
      var dateArrivalString = data.actualArrivalDate;
      var dateArrivalParts = dateArrivalString.split("-");
      this.leg_id = data.legId;
      this.legForm.get('flight_id')?.setValue(data.flight.flightId);
      this.actual_departure_date.setValue(new Date(+dateDepartureParts[2], dateDepartureParts[1] - 1, +dateDepartureParts[0]));
      this.actual_arrival_date.setValue(new Date(+dateArrivalParts[2], dateArrivalParts[1] - 1, +dateArrivalParts[0]));
      this.legForm.get('origin_airport_id')?.setValue(data.origin_airport.airportId);
      this.legForm.get('destination_airport_id')?.setValue(data.destination_airport.airportId);
      this.legForm.get('actual_departure_time')?.setValue(data.actualDepartureTime);
      this.legForm.get('actual_arrival_time')?.setValue(data.actualArrivalTime);
    });
  }

  editCost(id: number) {
    this.costoService.getCostsById(id).subscribe((data: any) => {
      var dateDepartureString = data.validFromDate;
      var dateDepartureParts = dateDepartureString.split("-");
      var dateArrivalString = data.validToDate;
      var dateArrivalParts = dateArrivalString.split("-");
      this.cost_id = data.costId;
      this.valid_from_date.setValue(new Date(+dateDepartureParts[2], dateDepartureParts[1] - 1, +dateDepartureParts[0]));
      this.valid_to_date.setValue(new Date(+dateArrivalParts[2], dateArrivalParts[1] - 1, +dateArrivalParts[0]));
      this.costForm.get('airline_id')?.setValue(data.airline.airline_id);
      this.costForm.get('flight_id')?.setValue(data.flight.flightId);
      this.costForm.get('flight_cost')?.setValue(data.flightCost);
    });
  }

  public deleteLeg(data: any) {
    const dialogRef = this.dialog.open(ModalDeleteComponent, {
      data: data,
    });

    if (this.id) {
      dialogRef.afterClosed().subscribe(result => {
        this.escalaService.getLegByFlightId(this.id).subscribe(data => {
          this.legs = data;
        });
      });
    } else {
      dialogRef.afterClosed().subscribe(result => {
        this.escalaService.getLegByFlightId(this.temp_id).subscribe(data => {
          this.legs = data;
        });
      });
    }
  }

  public deleteCost(data: any) {
    const dialogRef = this.dialog.open(ModalDeleteComponent, {
      data: data,
    });

    if (this.id) {
      dialogRef.afterClosed().subscribe(result => {
        this.costoService.getCostsByFlightId(this.id).subscribe(data => {
          this.costs = data;
        });
      });
    } else {
      dialogRef.afterClosed().subscribe(result => {
        this.costoService.getCostsByFlightId(this.temp_id).subscribe(data => {
          this.costs = data;
        });
      });
    }
  }

  public updateFlight() {
    if (this.flightForm.valid) {
      var body = new CreateVuelo();
      body.airlineId = this.flightForm.get('airline_id')?.value;
      body.airplaneId = this.flightForm.get('aircraft_id')?.value;
      body.departureDate = this.datePipe.transform(this.departure_date.value, 'dd-MM-yyyy')!;
      body.arrivalDate = this.datePipe.transform(this.arrival_date.value, 'dd-MM-yyyy')!;
      body.originAirportId = this.flightForm.get('origin_airport_id')?.value;
      body.destinationAirportId = this.flightForm.get('destination_airport_id')?.value;
      body.departureTime = this.flightForm.get('departure_time')?.value;
      body.arrivalTime = this.flightForm.get('arrival_time')?.value;
      if (this.id != 0) {
        var updateBody = new CreateVuelo();
        updateBody.airlineId = this.flightForm.get('airline_id')?.value;
        updateBody.airplaneId = this.flightForm.get('aircraft_id')?.value;
        updateBody.departureDate = this.datePipe.transform(this.departure_date.value, 'dd-MM-yyyy')!;
        updateBody.arrivalDate = this.datePipe.transform(this.arrival_date.value, 'dd-MM-yyyy')!;
        updateBody.originAirportId = this.flightForm.get('origin_airport_id')?.value;
        updateBody.destinationAirportId = this.flightForm.get('destination_airport_id')?.value;
        updateBody.departureTime = this.flightForm.get('departure_time')?.value;
        updateBody.arrivalTime = this.flightForm.get('arrival_time')?.value;
        this.vueloService.updateFlight(this.id, updateBody).subscribe();
      } else {
        this.vueloService.createFlight(body).subscribe((data: any) => {
          console.log(data);
          this.temp_id = data.flightId;
          this.airline_id = data.airline.airline_id;
        });;
      }
    }
  }

  public updateLeg() {
    this.legForm.get('flight_id')?.setValue(this.temp_id);
    if (this.legForm.valid) {
      var body = new CreateEscala();
      body.originAirportId = this.legForm.get('origin_airport_id')?.value;
      body.destinationAirportId = this.legForm.get('destination_airport_id')?.value;
      body.actualDepartureDate = this.datePipe.transform(this.actual_departure_date.value, 'dd-MM-yyyy')!;
      body.actualArrivalDate = this.datePipe.transform(this.actual_arrival_date.value, 'dd-MM-yyyy')!;
      body.actualArrivalTime = this.legForm.get('actual_arrival_time')?.value;
      body.actualDepartureTime = this.legForm.get('actual_departure_time')?.value;
      body.flightId = this.temp_id;;
      if (this.id != 0) {
        var updateBody = new CreateEscala();
        updateBody.originAirportId = this.legForm.get('origin_airport_id')?.value;
        updateBody.destinationAirportId = this.legForm.get('destination_airport_id')?.value;
        updateBody.actualDepartureDate = this.datePipe.transform(this.actual_departure_date.value, 'dd-MM-yyyy')!;
        updateBody.actualArrivalDate = this.datePipe.transform(this.actual_arrival_date.value, 'dd-MM-yyyy')!;
        updateBody.actualArrivalTime = this.legForm.get('actual_arrival_time')?.value;
        updateBody.actualDepartureTime = this.legForm.get('actual_departure_time')?.value;
        updateBody.flightId = this.id;
        this.escalaService.updateLeg(this.leg_id, updateBody).subscribe(data => {
          this.escalaService.getLegByFlightId(this.id).subscribe(data => {
            this.legs = data;
          });
        });
      } else {
        this.escalaService.createLeg(body).subscribe(data => {
          this.escalaService.getLegByFlightId(this.temp_id).subscribe(data => {
            this.legs = data;
          });
        });
      }
    }
  }

  public updateCost() {
    this.costForm.get('flight_id')?.setValue(this.temp_id);
    this.costForm.get('airline_id')?.setValue(this.airline_id);
    console.log(this.costForm.value)
    if (this.costForm.valid) {
      var body = new CreateCosto();
      body.airlineId = this.costForm.get('airline_id')?.value;
      body.flightId = this.temp_id;
      body.flightCost = this.costForm.get('flight_cost')?.value;
      body.validFromDate = this.datePipe.transform(this.valid_from_date.value, 'dd-MM-yyyy')!;
      body.validToDate = this.datePipe.transform(this.valid_to_date.value, 'dd-MM-yyyy')!;
      if (this.id != 0) {
        var body = new CreateCosto();
        body.airlineId = this.costForm.get('airline_id')?.value;
        body.flightId = this.temp_id;
        body.flightCost = this.costForm.get('flight_cost')?.value;
        body.validFromDate = this.datePipe.transform(this.valid_from_date.value, 'dd-MM-yyyy')!;
        body.validToDate = this.datePipe.transform(this.valid_to_date.value, 'dd-MM-yyyy')!;
        this.costoService.updateCost(this.cost_id, body).subscribe(data => {
          this.costoService.getCostsByFlightId(this.id).subscribe(data => {
            this.costs = data;
          });
        });
      } else {
        this.costoService.createCost(body).subscribe(data => {
          this.costoService.getCostsByFlightId(this.temp_id).subscribe(data => {
            this.costs = data;
          });
        });
      }
    }
  }
}
