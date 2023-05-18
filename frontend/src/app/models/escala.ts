import { Aereopuerto } from "./aereopuerto";
import { Vuelo } from "./vuelo";

export class Escala {
    legId!: number;
    flight!: Vuelo;
    origin_airport!: Aereopuerto;
    destination_airport!: Aereopuerto;
    actualDepartureDate!: string;
    actualArrivalDate!: string;
    actualDepartureTime!: string;
    actualArrivalTime!: string;
}