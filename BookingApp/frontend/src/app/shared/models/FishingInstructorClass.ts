import { Address } from "./Address";

export class FishingInstructorClass{
    public id : Number;
    public name : String;
    public address : Address;
    public description : String;
    public rules : String;
    public capacity : Number;
    public instructorBiography : String;
    public fishingInstructorId : Number;
    public averageGrade : Number;

    constructor(id : Number,name : String,address : Address,description : String, rules : String, capacity : Number,
                instructorBiography : String, fishingInstructorId : Number){
            this.address = address;
            this.description = description;
            this.id = id;
            this.name = name;
            this.rules = rules;
            this.capacity = capacity;
            this.instructorBiography = instructorBiography;
            this.fishingInstructorId = fishingInstructorId;
        }
}