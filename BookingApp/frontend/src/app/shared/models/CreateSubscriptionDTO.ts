
export class CreateSubscriptionDTO{
    public id : Number;
    public userId : Number ;
    public rentingItemId : Number ;

    constructor(id: Number,rentingItemId: Number,userId:Number){
        this.id = id;
        this.rentingItemId = rentingItemId;
        this.userId = userId;
    }
}