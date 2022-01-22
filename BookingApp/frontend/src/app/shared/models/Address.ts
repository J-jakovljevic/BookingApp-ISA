
export class Address{
    public id: Number;
    public latitude : Number;
    public longitude : Number;
    public street : String;
    public city : String;
    public state : String;


    constructor(id:Number, latitude: Number, longitude : Number, street : String, state : String,city : String){
        this.id = id;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
    }
}