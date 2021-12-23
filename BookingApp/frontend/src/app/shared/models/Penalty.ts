import { QuickReservation } from "./reservations/QuickReservation";

export class Penalty{
    public id : Number;
    public quickReservationId:Number;
    public quickReservation : QuickReservation;

    constructor(id : Number, quickReservationId : Number){
        this.id = id;
        this.quickReservationId = quickReservationId;
    }
}