import { AdditionalService } from "./AdditionalService";

export class Reservation{
    public id : Number;
    public clientId : Number;
    public rentingItemId : Number;
    public startTime : Date;
    public endTime : Date;
    public price : Number;
    public additionalServices : AdditionalService[];

    constructor(id : Number,clientId: Number,rentingItemId: Number,startTime: Date,endTime: Date,additionalServices:AdditionalService[]){
        this.id = id;
        this.clientId = clientId;
        this.rentingItemId = rentingItemId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.additionalServices = additionalServices;

    }
}