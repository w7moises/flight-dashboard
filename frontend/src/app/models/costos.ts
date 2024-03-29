import { Aereolinea } from "./aereolinea";
import { Vuelo } from "./vuelo";

export class Costos {
    costId!: number;
    flight!: Vuelo;
    airline!: Aereolinea;
    validFromDate!: string;
    validToDate!: string;
    flightCost!: number;
}