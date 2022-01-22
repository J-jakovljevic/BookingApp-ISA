import { RentingItem } from "./RentingItem";
import { ReservedRentingItem } from "./ReservedRentingItem";

export class Action{
    public id: Number;
    public rentingItemId: Number;
    public startTime: Date;
    public endTime: Date;
    public capacity : Number;
    public additionalServices : String;
    public price : Number;
    public reserved : Boolean;
    public rentingItem : RentingItem;
    public reservedRentingItem : ReservedRentingItem;

    constructor(id : Number, rentingItemId : Number,startTime : Date,endTime : Date,capacity: Number,
        additionalServices : String, price : Number, reserved : Boolean, rentingItem : RentingItem){
            this.id = id;
            this.rentingItemId = rentingItemId;
            this.startTime = startTime;
            this.endTime = endTime;
            this.capacity = capacity;
            this.additionalServices = additionalServices;
            this.price = price;
            this.reserved = reserved;
            this.rentingItem = rentingItem;
            
        }
}

