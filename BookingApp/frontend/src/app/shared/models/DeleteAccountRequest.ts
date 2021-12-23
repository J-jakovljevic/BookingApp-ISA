export class DeleteAccountRequest{
    public id : Number;
    public description : String;
    public approved : boolean ;
    public clientId : Number;

    constructor(id:Number, description : String, approved : boolean, clientId : Number){
        this.id = id;
        this.description = description;
        this.approved = approved;
        this.clientId = clientId;
    }

}