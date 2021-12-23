export class ReservedRentingItem{
    public id : Number;
    public name : String;
    public address: String;
    public description : String;
    public rules : String;
    public capacity : Number;
    public instructorBiography : String;
    public fishingInstructorId : Number;
    public type : String;
    public length : Number;
    public engineNumber : Number;
    public maxSpeed : Number;
    public navigationEquipment : String;
    public additionalFishingEquipment : String;
    public cancellationTerms : String;

    constructor(id : Number,name : String,address : String,description : String,type : String,
        length : Number, engineNumber : Number, maxSpeed : Number, navigationEquipment : String,
        additionalFishingEquipment : String, cancellationTerms : String, rules : String, capacity : Number,
        instructorBiography : String,fishingInstructorId : Number){
            this.additionalFishingEquipment = additionalFishingEquipment;
            this.address = address;
            this.cancellationTerms = cancellationTerms;
            this.description = description;
            this.engineNumber = engineNumber;
            this.id = id;
            this.length = length;
            this.maxSpeed = maxSpeed;
            this.name = name;
            this.navigationEquipment = navigationEquipment;
            this.rules = rules;
            this.type = type;
            this.capacity = capacity;
            this.instructorBiography = instructorBiography;
            this.fishingInstructorId = fishingInstructorId;
        }
}