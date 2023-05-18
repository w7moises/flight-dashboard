import { Aereolinea } from "./aereolinea";
import { Aereopuerto } from "./aereopuerto";
import { Avion } from "./avion";

export class Vuelo {
    flightId!: number;
    airline: Aereolinea = new Aereolinea();
    airplane: Avion = new Avion();
    originAirport!: Aereopuerto;
    destinationAirport!: Aereopuerto;
    departureDate!: string;
    arrivalDate!: string;
    departureTime!: string;
    arrivalTime!: string;
}