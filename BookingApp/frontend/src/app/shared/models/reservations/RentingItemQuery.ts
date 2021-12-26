export class RentingItemQuery{
    public startDate: Date;
    public endDate: Date;
    public capacity: Number;
    public rentingItemType : String;

    constructor(startTime: Date,endTime: Date, capacity: Number,type: String){
        this.startDate = startTime;
        this.endDate = endTime;
        this.capacity = capacity;
        this.rentingItemType = type;
    }
}