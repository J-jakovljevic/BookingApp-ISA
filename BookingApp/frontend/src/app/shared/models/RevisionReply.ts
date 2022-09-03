import { Revision } from "./Revision";

export class RevisionReply{
    public id : Number;
    public revision : Revision;
    public ownerId : Number;
    public description : String;

    constructor(id : Number,revision : Revision, ownerId : Number,description : String){
        this.id = id;
        this.revision = revision;
        this.ownerId = ownerId;
        this.description = description;
    }
}
