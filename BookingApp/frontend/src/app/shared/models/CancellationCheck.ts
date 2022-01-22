export class CancellationCheckDTO{
    public clientId : Number;
    public rentingItemId : Number;
    public startTime : Date;
    public endTime : Date;

    constructor(clientId : Number,rentingItemId : Number, startTime : Date,endTime: Date){
        this.clientId = clientId;
        this.rentingItemId = rentingItemId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}