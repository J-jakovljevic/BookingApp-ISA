export class ComplaintReply{
    public id : Number;
    public clientId : Number;
    public rentingItemId : Number;
    public description : Number;

    constructor(id:Number,clientId:Number,rentingItemId:Number,description:Number){
        this.id = id;
        this.clientId = clientId;
        this.rentingItemId = rentingItemId;
        this.description = description;
    }
}