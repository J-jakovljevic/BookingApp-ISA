import { Address } from "../Address";

export class FishingInstructor{
    public id:Number;
    public name : String;
    public surname : String;
    public address : String;
    public email : String;
    public phoneNumber : String;
    public role : String;

    constructor(id:Number, name:String, surname : String ,phoneNumber : String, email : String, address : String, role : String){
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.role = role;
    }

}
