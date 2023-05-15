export class Reserva {
    reservation_id!: number;
    agent_id!: number;
    passenger_id!: number;
    reservation_status_code!: string;
    ticket_code!: string;
    travel_type_class!: string;
    reservation_date!: Date;
    number_in_party!: number;
}