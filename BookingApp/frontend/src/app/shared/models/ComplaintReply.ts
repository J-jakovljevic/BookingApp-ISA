export class ComplaintReply{
    public id : Number;
    public clientId : Number;
    public rentingItemId : Number;
    public description : String;

    constructor(id:Number,clientId:Number,rentingItemId:Number,description:String){
        this.id = id;
        this.clientId = clientId;
        this.rentingItemId = rentingItemId;
        this.description = description;
    }
}