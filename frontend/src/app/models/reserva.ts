import { Agente } from "./agente";
import { Pasajero } from "./pasajero";

export class Reserva {
    reservationId!: number;
    agent!: Agente;
    passenger!: Pasajero;
    reservationStatusCode!: string;
    ticketCode!: string;
    travelTypeClass!: string;
    reservationDate!: Date;
    numberInParty!: number;
}