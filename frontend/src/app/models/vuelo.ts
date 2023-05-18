import { Aereolinea } from "./aereolinea";
import { Aereopuerto } from "./aereopuerto";
import { Avion } from "./avion";

export class Vuelo {
    flightId!: number;
    airline!: Aereolinea;
    aircraft!: Avion;
    originAirport!: Aereopuerto;
    destinationAirport!: Aereopuerto;
    departureTime!: string;
    arrivalTime!: string;
}