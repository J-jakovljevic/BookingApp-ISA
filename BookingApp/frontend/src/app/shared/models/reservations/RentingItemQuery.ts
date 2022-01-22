export class RentingItemQuery{
    public startDate: Date;
    public endDate: Date;
    public capacity: Number;
    public rentingItemType : String;
    public location : String;
    public grade : Number;

    constructor(startTime: Date,endTime: Date, capacity: Number,type: String,location : String, grade : Number){
        this.startDate = startTime;
        this.endDate = endTime;
        this.capacity = capacity;
        this.rentingItemType = type;
        this.location = location;
        this.grade = grade;
    }
}