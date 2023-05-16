import { Aereopuerto } from "./aereopuerto";
import { Vuelo } from "./vuelo";

export class Escala {
    leg_id!: number;
    flight!: Vuelo;
    origin_airport!: Aereopuerto;
    destination_airport!: Aereopuerto;
    actual_departure_date!: Date;
    actual_arrival_date!: Date;
    actual_departure_time!: string;
    actual_arrival_time!: string;
}