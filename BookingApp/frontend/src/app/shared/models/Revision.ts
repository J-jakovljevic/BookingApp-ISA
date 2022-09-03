import { RentingItem } from "./reservations/RentingItem";

export class Revision{
    public id : Number;
    public clientId : Number;
    public rentingItemId : Number;
    public grade : Number;
    public description : String;
    public rentingItem : RentingItem;
    public reservationId : Number;

    constructor(id : Number,clientId : Number, rentingItemId : Number,grade : Number,description : String, reservationId : Number){
        this.id = id;
        this.clientId = clientId;
        this.rentingItemId = rentingItemId;
        this.grade = grade;
        this.description = description;
        this.reservationId = reservationId;
    }
}