import { Address } from "./Address";

export class Cottage{
    public id : Number;
    public name : String;
    public address : String;
    public description : String;
    public rules : String;
    public capacity : Number;
    public averageGrade : Number;
    public ownerId : Number;

    constructor(id : Number,name : String,address : String,description : String, rules : String, capacity : Number, ownerId : Number){
            this.address = address;
            this.description = description;
            this.id = id;
            this.name = name;
            this.rules = rules;
            this.capacity = capacity;
            this.ownerId = ownerId;

        }
}