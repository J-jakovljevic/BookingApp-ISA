import { AdditionalService } from "./AdditionalService";
import { RentingItem } from "./reservations/RentingItem";
import { ReservedRentingItem } from "./reservations/ReservedRentingItem";

export class Reservation{
    public id : Number;
    public clientId : Number;
    public rentingItemId : Number;
    public startTime : Date;
    public endTime : Date;
    public price : Number;
    public additionalServices : AdditionalService[];
    public rentingItem : RentingItem;
    public reservedRentingItem : ReservedRentingItem;

    constructor(id : Number,clientId: Number,rentingItemId: Number,startTime: Date,endTime: Date,additionalServices:AdditionalService[],price:Number){
        this.id = id;
        this.clientId = clientId;
        this.rentingItemId = rentingItemId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.additionalServices = additionalServices;
        this.price = price;

    }
}