import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-modal.delete',
  templateUrl: './modal.delete.component.html',
  styleUrls: ['./modal.delete.component.scss']
})
export class ModalDeleteComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: String, public dialogRef: MatDialogRef<ModalDeleteComponent>,) { }
  
  onNoClick(): void {
    this.dialogRef.close();
  }
}
