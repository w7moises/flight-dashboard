import { Agente } from "./agente";
import { Pasajero } from "./pasajero";

export class Reserva {
    reservation_id!: number;
    agent!: Agente;
    passenger!: Pasajero;
    reservation_status_code!: string;
    ticket_code!: string;
    travel_type_class!: string;
    reservation_date!: Date;
    number_in_party!: number;
}