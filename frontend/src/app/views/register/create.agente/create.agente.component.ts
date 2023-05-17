import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Agente } from 'src/app/models/agente';
import { AgenteService } from 'src/app/services/agente.service';

@Component({
  selector: 'app-create.agente',
  templateUrl: './create.agente.component.html',
  styleUrls: ['./create.agente.component.scss']
})
export class CreateAgenteComponent {
  title: string = 'Registrar';
  id: number = 0;
  agentForm!: FormGroup;

  constructor(private router: Router, private route: ActivatedRoute, private service: AgenteService) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.agentForm = new FormGroup({
      agent_name: new FormControl('', Validators.required),
      agent_details: new FormControl('', Validators.required),
    });
    if (this.id != 0) {
      this.title = 'Editar';
      this.service.getAgentById(this.id).subscribe((data: any) => {
        this.agentForm.get('agent_name')?.setValue(data.agentName);
        this.agentForm.get('agent_details')?.setValue(data.agentDetails);
      });
    }
  }

  public createAgent() {
    if (this.agentForm.valid) {
      var body = new Agente();
      var updateBody = new Agente();
      body.agentName = this.agentForm.get('agent_name')?.value;
      body.agentDetails = this.agentForm.get('agent_details')?.value;
      if (this.id != 0) {
        updateBody.agentName = this.agentForm.get('agent_name')?.value;
        updateBody.agentDetails = this.agentForm.get('agent_details')?.value;
        this.service.updateAgent(this.id, updateBody).subscribe((data: any) => { this.redirectTo('dashboard/supervisor'); });
      } else {
        this.service.createAgent(body).subscribe((data: any) => {
          this.redirectTo('dashboard/supervisor');
        });
      }
    }
  }

  public redirectTo(uri: string) {
    this.router.navigate([uri]);
  }
}
