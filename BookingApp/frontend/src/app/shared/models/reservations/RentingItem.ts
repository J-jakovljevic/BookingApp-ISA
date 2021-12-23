export class RentingItem{
    public id : Number;
    public name : String;
    public address: String;
    public description : String;

    constructor(id : Number,name : String, address : String,description : String){
        this.id = id;
        this.address = address;
        this.name = name;
        this.description = description;
    }

}