import { Action } from "@ngrx/store";

export function RoleReducer(state : string = 'unauthenticatedUser',action : Action){
    console.log(action.type,state)

    switch(action.type){
        case 'CLIENT':
            return state = 'Client';
        case 'FISHING_INSTRUCTOR':
            return state = 'FishingInstructor';
        case 'BOAT_OWNER':
            return state = 'BoatOwner';
        case 'COTTAGE_OWNER':
            return state = 'CottageOwner';
        case 'SYSTEM_ADMIN':
            return state = 'SystemAdmin';
        default:
            return state;
    }
}