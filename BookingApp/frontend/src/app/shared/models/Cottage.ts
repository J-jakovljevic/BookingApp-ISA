import { Address } from "./Address";

export class Cottage{
    public id : Number;
    public name : String;
    public address : String;
    public description : String;
    public rules : String;
    public capacity : Number;

    constructor(id : Number,name : String,address : String,description : String, rules : String, capacity : Number){
            this.address = address;
            this.description = description;
            this.id = id;
            this.name = name;
            this.rules = rules;
            this.capacity = capacity;
        }
}