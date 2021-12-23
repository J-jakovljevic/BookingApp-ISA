
import { Client } from "../Client";
import { Action } from "./Action";

export class QuickReservation{
    public id : Number;
    public client : Client;
    public action : Action;

    constructor(id : Number, client : Client, action : Action){
        this.id = id;
        this.client = client;
        this.action = action;
    }
}