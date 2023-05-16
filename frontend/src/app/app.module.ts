import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './views/login/login.component';
import { TableComponent } from './components/table/table.component';
import { TopnavbarComponent } from './components/topnavbar/topnavbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardPasajeroComponent } from './views/dashboard.pasajero/dashboard.pasajero.component';
import { AngularMaterialModule } from './modules/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PasarelaComponent } from './components/pasarela/pasarela.component';
import { TarjetaComponent } from './components/tarjeta/tarjeta.component';
import { ModalDeleteComponent } from './components/modal.delete/modal.delete.component';
import { DashboardReservasComponent } from './views/dashboard.agente/dashboard.reservas/dashboard.reservas.component';
import { DashboardPasajerosComponent } from './views/dashboard.agente/dashboard.pasajeros/dashboard.pasajeros.component';
import { DashboardVuelosComponent } from './views/dashboard.supervisor/dashboard.vuelos/dashboard.vuelos.component';
import { DashboardAereopuertosComponent } from './views/dashboard.supervisor/dashboard.aereopuertos/dashboard.aereopuertos.component';
import { DashboardAgentesComponent } from './views/dashboard.supervisor/dashboard.agentes/dashboard.agentes.component';
import { CreateAereopuertoComponent } from './views/register/create.aereopuerto/create.aereopuerto.component';
import { CreateAgenteComponent } from './views/register/create.agente/create.agente.component';
import { CreatePasajeroComponent } from './views/register/create.pasajero/create.pasajero.component';
import { CreateReservaComponent } from './views/register/create.reserva/create.reserva.component';
import { CreateVueloComponent } from './views/register/create.vuelo/create.vuelo.component';
import { HttpClientModule } from '@angular/common/http';
import { FilterPipe } from './pipe/filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TopnavbarComponent,
    DashboardPasajeroComponent,
    PasarelaComponent,
    TarjetaComponent,
    ModalDeleteComponent,
    TableComponent,
    DashboardReservasComponent,
    DashboardPasajerosComponent,
    DashboardVuelosComponent,
    DashboardAereopuertosComponent,
    DashboardAgentesComponent,
    CreateAereopuertoComponent,
    CreateAgenteComponent,
    CreatePasajeroComponent,
    CreateReservaComponent,
    CreateVueloComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    AngularMaterialModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
