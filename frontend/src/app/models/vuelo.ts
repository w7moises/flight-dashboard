import { Aereolinea } from "./aereolinea";
import { Aereopuerto } from "./aereopuerto";
import { Avion } from "./avion";

export class Vuelo {
    flight_id!: number;
    airline!: Aereolinea;
    aircraft!: Avion;
    origin_airport!: Aereopuerto;
    destination_airport!: Aereopuerto;
    departure_time!: string;
    arrival_time!: string;
}