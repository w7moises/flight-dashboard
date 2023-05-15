import { Component, Input, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { ModalDeleteComponent } from '../modal.delete/modal.delete.component';
import { PasajeroService } from 'src/app/services/pasajero.service';
import { Pasajero } from 'src/app/models/pasajero';
import { Agente } from 'src/app/models/agente';
import { AgenteService } from 'src/app/services/agente.service';

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
  pasajeroPage: Pasajero[] = [];
  pasajeroFlag: boolean = false;
  agentePage: Agente[] = [];
  agenteFlag: boolean = false;
  totalRegisters: number = 0;
  flag: boolean = false;
  actualPage: number = 0;
  totalPage: number = 5;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private router: Router, private dialog: MatDialog, private pasajeroService: PasajeroService,
    private agenteService: AgenteService) { }

  ngOnInit(): void {
    this.calculateRange();
    if (this.data == 'agente/pasajero') {
      this.pasajeroFlag = true;
    }
    if (this.data == 'supervisor') {
      this.agenteFlag = true;
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
    if (this.data == 'supervisor') {
      this.agenteService.getAgents(this.actualPage.toString(), this.totalPage.toString()).subscribe((data: any) => {
        this.totalRegisters = data.totalElements as number;
        this.agentePage = data.content as Agente[];
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
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.passenger_id }]);
    }
    else {
      this.router.navigate(['dashboard/' + this.data + '/create', { id: body.agent_id }]);
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
