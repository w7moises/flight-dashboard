import { Component, Input, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { ModalDeleteComponent } from '../modal.delete/modal.delete.component';
import { PasajeroService } from 'src/app/services/pasajero.service';
import { Pasajero } from 'src/app/models/pasajero';
import { Agente } from 'src/app/models/agente';
import { AgenteService } from 'src/app/services/agente.service';
import { Aereopuerto } from 'src/app/models/aereopuerto';
import { AereopuertoService } from 'src/app/services/aereopuerto.service';
import { Reserva } from 'src/app/models/reserva';
import { ReservaService } from '../../services/reserva.service';
import { Vuelo } from 'src/app/models/vuelo';
import { VueloService } from 'src/app/services/vuelo.service';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent {
  @Input() paths: string[] = [];
  @Input() title: string = '';
  @Input() data: string = '';
  @Input() state: boolean = true;
  @Input() body: string[] = [];
  filterPost = '';
  pasajeroPage: Pasajero[] = [];
  pasajeroFlag: boolean = false;
  agentePage: Agente[] = [];
  agenteFlag: boolean = false;
  button: string = 'Editar';
  aereopuertoPage: Aereopuerto[] = [];
  aereopuertoFlag: boolean = false;
  vueloPage: Vuelo[] = [];
  vueloFlag: boolean = false;
  reservaPage: Reserva[] = [];
  reservaFlag: boolean = false;
  totalRegisters: number = 0;
  flag: boolean = false;
  actualPage: number = 0;
  totalPage: number = 5;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  email: string = '';

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private router: Router, private dialog: MatDialog, private pasajeroService: PasajeroService,
    private agenteService: AgenteService, private aereopuertoService: AereopuertoService, private reservaService: ReservaService,
    private vueloService: VueloService, private loginService: LoginService) { }

  ngOnInit(): void {
    this.email = this.loginService.getEmail()!;
    this.calculateRange();
    if (this.data == 'agente/pasajero') {
      this.pasajeroFlag = true;
    }
    if (this.data == 'supervisor') {
      this.agenteFlag = true;
    }
    if (this.data == 'supervisor/vuelos') {
      this.vueloFlag = true;
    }
    if (this.data == 'supervisor/aereopuertos') {
      this.aereopuertoFlag = true;
    }
    if (this.data == 'agente') {
      this.reservaFlag = true;
    }
    if (this.data == 'pasajero') {
      this.button = 'Pagar';
      this.reservaFlag = true;
    }
  }

  paging(event: PageEvent): void {
    this.actualPage = event.pageIndex;
    this.totalPage = event.pageSize;
    this.calculateRange();
  }

  private calculateRange() {
    if (this.data == 'agente/pasajero') {
      this.pasajeroService.getPassengers(this.actualPage.toString(), this.totalPage.toString()).subscribe((data: any) => {
        this.totalRegisters = data.totalElements as number;
        this.pasajeroPage = data.content as Pasajero[];
      });
    }
    if (this.data == 'agente') {
      this.reservaService.getReservations(this.actualPage.toString(), this.totalPage.toString()).subscribe((data: any) => {
        this.totalRegisters = data.totalElements as number;
        this.reservaPage = data.content as Reserva[];
      });
    }
    if (this.data == 'pasajero') {
      this.reservaService.getReservationsByEmail(this.email).subscribe((data: any) => {
        this.totalRegisters = data.totalElements as number;
        this.reservaPage = data as Reserva[];
      });
    }
    if (this.data == 'supervisor') {
      this.agenteService.getAgents(this.actualPage.toString(), this.totalPage.toString()).subscribe((data: any) => {
        this.totalRegisters = data.totalElements as number;
        this.agentePage = data.content as Agente[];
      });
    }
    if (this.data == 'supervisor/vuelos') {
      this.vueloService.getFlights(this.actualPage.toString(), this.totalPage.toString()).subscribe((data: any) => {
        this.totalRegisters = data.totalElements as number;
        this.vueloPage = data.content as Vuelo[];
      });
    }
    if (this.data == 'supervisor/aereopuertos') {
      this.aereopuertoService.getAirports(this.actualPage.toString(), this.totalPage.toString()).subscribe((data: any) => {
        this.totalRegisters = data.totalElements as number;
        this.aereopuertoPage = data.content as Aereopuerto[];
      });
    }
  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }

  public create() {
    this.router.navigate(['dashboard/' + this.data + '/create', { id: 0 }]);
  }

  public edit(body: any) {
    if (this.data == 'agente/pasajero') {
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.passengerId }]);
    }
    if (this.data == 'agente') {
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.reservationId }]);
    }
    if (this.data == 'pasajero') {
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.reservationId }]);
    }
    if (this.data == 'supervisor') {
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.agentId }]);
    }
    if (this.data == 'supervisor/vuelos') {
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.flightId }]);
    }
    if (this.data == 'supervisor/aereopuertos') {
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.airportId }]);
    }
  }

  public delete(data: any) {
    const dialogRef = this.dialog.open(ModalDeleteComponent, {
      data: data,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.calculateRange();
    });
  }
}
