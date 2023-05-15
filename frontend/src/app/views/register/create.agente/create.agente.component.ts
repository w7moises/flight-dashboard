import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create.agente',
  templateUrl: './create.agente.component.html',
  styleUrls: ['./create.agente.component.scss']
})
export class CreateAgenteComponent {
  title: string = 'Registrar';
  id: number = 0;
  agentForm = new FormGroup({
    agent_name: new FormControl('', Validators.required),
    agent_details: new FormControl('', Validators.required),
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
