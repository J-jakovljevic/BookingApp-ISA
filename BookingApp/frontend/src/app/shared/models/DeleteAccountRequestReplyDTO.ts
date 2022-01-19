export class DeleteAccountRequestReplyDTO{
    public deleteAccountRequestId : Number;
    public description : String;
    public clientId : Number;

    constructor(deleteAccountRequestId : Number,description : String,clientId : Number ){
        this.deleteAccountRequestId = deleteAccountRequestId;
        this.description = description;
        this.clientId = clientId;
    }

}