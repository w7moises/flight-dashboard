import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create.reserva',
  templateUrl: './create.reserva.component.html',
  styleUrls: ['./create.reserva.component.scss']
})
export class CreateReservaComponent {
  title: string = 'Registrar';
  id: number = 0;
  bookingForm = new FormGroup({
    travel_type_class: new FormControl('', Validators.required),
    number_in_party: new FormControl('', Validators.required),
  });
  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    if (this.id != 0) {
      this.title = 'Editar';
    }
  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
