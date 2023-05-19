import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PagoService } from '../../services/pago.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Pago } from 'src/app/models/pago';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-tarjeta',
  templateUrl: './tarjeta.component.html',
  styleUrls: ['./tarjeta.component.scss']
})
export class TarjetaComponent {
  options: number = 0;
  paymentForm!: FormGroup;
  url!: string;
  @Input() id: number = 0;

  constructor(private router: Router, private route: ActivatedRoute, private pagoService: PagoService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.paymentForm = new FormGroup({
      name: new FormControl('', Validators.required),
      number: new FormControl('', Validators.required),
      cvv: new FormControl('', Validators.required),
      month: new FormControl('', Validators.required),
      year: new FormControl('', Validators.required),
    });
  }

  public changeOption(option: number) {
    this.options = option;
  }

  pay() {
    if (this.paymentForm.valid) {
      var body = new Pago();
      body.reservationId = this.id;
      body.paymentAmount = 100;
      this.pagoService.createPayment(body).subscribe((data: any) => {
        if (data.length != 0) {
          this.snackBar.open(
            'Esperando confirmación de pago',
            '',
            {
              duration: 3000,
              panelClass: ['red-snackbar'],
            }
          );
        }
        this.router.navigate(['/dashboard/pasajero']);
      });
    }
  }
}
