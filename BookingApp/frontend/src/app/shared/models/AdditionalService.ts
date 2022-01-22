export class AdditionalService{
    public id:Number;
    public rentingItemId:Number;
    public description:String;

    constructor(id:Number, rentingItemId:Number, description:String){
        this.id = id;
        this.rentingItemId = rentingItemId;
        this.description = description;
    }
}