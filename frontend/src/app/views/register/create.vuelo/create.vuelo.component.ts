import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create.vuelo',
  templateUrl: './create.vuelo.component.html',
  styleUrls: ['./create.vuelo.component.scss']
})
export class CreateVueloComponent {
  title: string = 'Registrar';
  id: number = 0;
  flightForm = new FormGroup({
    firstCtrl: new FormControl('', Validators.required),
  });
  legForm = new FormGroup({
    firstCtrl: new FormControl('', Validators.required),
  });
  costForm = new FormGroup({
    valid_from_date: new FormControl('', Validators.required),
    valid_to_date: new FormControl('', Validators.required),
    flight_cost: new FormControl('', Validators.required),
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

  addCost() {
    console.log(this.costForm.value);
  }

}
