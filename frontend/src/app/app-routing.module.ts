import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './views/login/login.component';
import { DashboardPasajeroComponent } from './views/dashboard.pasajero/dashboard.pasajero.component';
import { PasarelaComponent } from './components/pasarela/pasarela.component';
import { DashboardReservasComponent } from './views/dashboard.agente/dashboard.reservas/dashboard.reservas.component';
import { DashboardPasajerosComponent } from './views/dashboard.agente/dashboard.pasajeros/dashboard.pasajeros.component';
import { DashboardAgentesComponent } from './views/dashboard.supervisor/dashboard.agentes/dashboard.agentes.component';
import { DashboardAereopuertosComponent } from './views/dashboard.supervisor/dashboard.aereopuertos/dashboard.aereopuertos.component';
import { DashboardVuelosComponent } from './views/dashboard.supervisor/dashboard.vuelos/dashboard.vuelos.component';
import { CreateAereopuertoComponent } from './views/register/create.aereopuerto/create.aereopuerto.component';
import { CreateAgenteComponent } from './views/register/create.agente/create.agente.component';
import { CreatePasajeroComponent } from './views/register/create.pasajero/create.pasajero.component';
import { CreateReservaComponent } from './views/register/create.reserva/create.reserva.component';
import { CreateVueloComponent } from './views/register/create.vuelo/create.vuelo.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'dashboard/pasajero', component: DashboardPasajeroComponent },
  { path: 'dashboard/pasajero/create', component: PasarelaComponent },
  { path: 'dashboard/agente', component: DashboardReservasComponent },
  { path: 'dashboard/agente/create', component: CreateReservaComponent },
  { path: 'dashboard/agente/pasajero', component: DashboardPasajerosComponent },
  { path: 'dashboard/agente/pasajero/create', component: CreatePasajeroComponent },
  { path: 'dashboard/supervisor', component: DashboardAgentesComponent },
  { path: 'dashboard/supervisor/create', component: CreateAgenteComponent },
  { path: 'dashboard/supervisor/vuelos', component: DashboardVuelosComponent },
  { path: 'dashboard/supervisor/vuelos/create', component: CreateVueloComponent },
  { path: 'dashboard/supervisor/aereopuertos', component: DashboardAereopuertosComponent },
  { path: 'dashboard/supervisor/aereopuertos/create', component: CreateAereopuertoComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
