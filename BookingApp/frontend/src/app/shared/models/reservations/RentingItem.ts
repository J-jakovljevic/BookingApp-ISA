import { AdditionalService } from "../AdditionalService";

export class RentingItem{
    public id : Number;
    public name : String;
    public address: String;
    public description : String;
    public capacity : Number;
    public additionalServices : AdditionalService[];
    public averageGrade : Number;
    public type : String;

    constructor(id : Number,name : String, address : String,description : String,capacity: Number){
        this.id = id;
        this.address = address;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
    }

}