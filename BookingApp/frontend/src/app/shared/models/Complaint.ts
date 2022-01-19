import { Client } from "./Client";
import { RentingItem } from "./reservations/RentingItem";

export class Complaint{
    public id : Number;
    public clientId : Number;
    public rentingItemId : Number;
    public description : String;
    public client : Client;
    public rentingItem : RentingItem;

    constructor(id:Number,clientId:Number,rentingItemId:Number,description:String){
        this.id = id;
        this.clientId = clientId;
        this.rentingItemId = rentingItemId;
        this.description = description;
    }
}