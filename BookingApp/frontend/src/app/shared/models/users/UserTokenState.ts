import { User } from "./User";

export class UserTokenState{
    public user : User;
    public accessToken : String;
    public expiresIn : Number;

    constructor(user : User ,accessToken : String, expiresIn : Number){
        this.user = user;
        this.expiresIn = expiresIn;
        this.accessToken= accessToken;
    }

}