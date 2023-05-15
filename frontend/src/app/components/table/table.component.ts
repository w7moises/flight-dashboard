import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { ModalDeleteComponent } from '../modal.delete/modal.delete.component';

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
  totalRegisters: number = 0;
  flag: boolean = false;
  actualPage: number = 0;
  totalPage: number = 5;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  constructor(private router: Router, private dialog: MatDialog) { }

  ngOnInit(): void {

  }

  paging(event: PageEvent): void {
    this.actualPage = event.pageIndex;
    this.totalPage = event.pageSize;
    this.calculateRange();
  }

  private calculateRange() {

  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }

  public create() {
    this.router.navigate(['dashboard/' + this.data + '/create', { id: 0 }]);
  }

  public edit(body: any) {
    this.router.navigate(['dashboard/' + this.data + '/create', { id: 1 }]);
  }

  public delete() {
    const dialogRef = this.dialog.open(ModalDeleteComponent, {
      data: 'hola',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
