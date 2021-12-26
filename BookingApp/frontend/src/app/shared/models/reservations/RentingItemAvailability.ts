import { RentingItem } from "./RentingItem";

export class RentingItemAvailability{
    public id : Number;
    public rentingItemId: Number;
    public startTime: Date;
    public endTime: Date;
    public price: Number;
    public rentingItem : RentingItem;

    constructor(id:Number,rentingItemId:Number,startTime : Date,endTime : Date,price:Number){
        this.id = id;
        this.rentingItemId = rentingItemId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }
    
}