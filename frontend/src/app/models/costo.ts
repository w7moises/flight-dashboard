import { Aereolinea } from "./aereolinea";
import { Vuelo } from "./vuelo";

export class Costo {
    costId!: number;
    flight!: Vuelo;
    airline!: Aereolinea;
    validFromDate!: Date;
    validToDate!: Date;
    flightCost!: number;
}