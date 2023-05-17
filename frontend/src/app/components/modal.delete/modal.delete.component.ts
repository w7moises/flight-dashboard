import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Pasajero } from 'src/app/models/pasajero';
import { PasajeroService } from '../../services/pasajero.service';
import { AgenteService } from 'src/app/services/agente.service';
import { AereopuertoService } from 'src/app/services/aereopuerto.service';
import { ReservaService } from 'src/app/services/reserva.service';
import { VueloService } from 'src/app/services/vuelo.service';

@Component({
  selector: 'app-modal.delete',
  templateUrl: './modal.delete.component.html',
  styleUrls: ['./modal.delete.component.scss']
})
export class ModalDeleteComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<ModalDeleteComponent>,
    private pasajeroService: PasajeroService, private agenteService: AgenteService, private aereopuertoService: AereopuertoService,
    private reservationService: ReservaService, private vueloService: VueloService) { }

  onClick(): void {
    if (this.data.hasOwnProperty('passengerId')) {
      this.pasajeroService.deletePassenger(this.data.passengerId).subscribe((data: any) => { this.dialogRef.close() });
    }
    if (this.data.hasOwnProperty('agentId')) {
      this.agenteService.deleteAgent(this.data.agentId).subscribe((data: any) => { this.dialogRef.close() });
    }
    if (this.data.hasOwnProperty('airportId')) {
      this.aereopuertoService.deleteAirport(this.data.airportId).subscribe((data: any) => { this.dialogRef.close() });
    }
    if (this.data.hasOwnProperty('reservationId')) {
      this.reservationService.deleteReservation(this.data.reservation_id).subscribe((data: any) => { this.dialogRef.close() });
    }
    if (this.data.hasOwnProperty('flight_id')) {
      this.vueloService.deleteFlight(this.data.flight_id).subscribe((data: any) => { this.dialogRef.close() });
    }
    this.dialogRef.close();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
