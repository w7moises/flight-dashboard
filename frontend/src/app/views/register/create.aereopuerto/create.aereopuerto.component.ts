import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create.aereopuerto',
  templateUrl: './create.aereopuerto.component.html',
  styleUrls: ['./create.aereopuerto.component.scss']
})
export class CreateAereopuertoComponent {
  title: string = 'Registrar';
  id: number = 0;
  airportForm = new FormGroup({
    airport_name: new FormControl('', Validators.required),
    airport_location: new FormControl('', Validators.required),
    other_details: new FormControl('', Validators.required)
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
