export class LoyaltyProgram{
    public id : Number;
    public pointsPerReservation: Number;
    public silverMemberThreshold: Number;
    public goldenMemberThreshold: Number;

    constructor(id : Number,pointsPerRes : Number,silverMemberThreshold : Number,goldMemberThreshold : Number){
        this.id = id;
        this.pointsPerReservation = pointsPerRes;
        this.silverMemberThreshold = silverMemberThreshold;
        this.goldenMemberThreshold = goldMemberThreshold;
    }
}