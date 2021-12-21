import { Client } from "./Client";
import { RentingItem } from "./reservations/RentingItem";

export class Subscription{
    public id : Number;
    public userId : Number ;
    public rentingItemId : Number ;
    public client : Client;
    public rentingItem : RentingItem;

    constructor(id: Number, client : Client, rentingItem : RentingItem,rentingItemId: Number,
        userId:Number){
        this.id = id;
        this.client = client;
        this.rentingItem = rentingItem;
        this.rentingItemId = rentingItemId;
        this.userId = userId;
    }
}