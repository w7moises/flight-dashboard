import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Pasajero } from 'src/app/models/pasajero';
import { PasajeroService } from '../../services/pasajero.service';
import { AgenteService } from 'src/app/services/agente.service';
import { AereopuertoService } from 'src/app/services/aereopuerto.service';

@Component({
  selector: 'app-modal.delete',
  templateUrl: './modal.delete.component.html',
  styleUrls: ['./modal.delete.component.scss']
})
export class ModalDeleteComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<ModalDeleteComponent>,
    private pasajeroService: PasajeroService, private agenteService: AgenteService, private aereopuertoService: AereopuertoService) { }

  onClick(): void {
    if (this.data.hasOwnProperty('passenger_id')) {
      this.pasajeroService.deletePassenger(this.data.passenger_id).subscribe((data: any) => { this.dialogRef.close() });
    }
    if (this.data.hasOwnProperty('agent_id')) {
      this.agenteService.deleteAgent(this.data.agent_id).subscribe((data: any) => { this.dialogRef.close() });
    }
    if (this.data.hasOwnProperty('airport_id')) {
      this.aereopuertoService.deleteAirport(this.data.airport_id).subscribe((data: any) => { this.dialogRef.close() });
    }
    this.dialogRef.close();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
