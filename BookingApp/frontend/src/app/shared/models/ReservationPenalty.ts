import { Reservation } from "./Reservation";
import { QuickReservation } from "./reservations/QuickReservation";

export class ReservationPenalty{
    public id : Number;
    public reservationId:Number;
    public reservation : Reservation;

    constructor(id : Number, reservationId : Number){
        this.id = id;
        this.reservationId = reservationId;
    }
}