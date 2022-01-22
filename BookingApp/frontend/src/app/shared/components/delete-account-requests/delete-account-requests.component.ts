import { Component, OnInit } from '@angular/core';
import { DeleteAccountRequest } from '../../models/DeleteAccountRequest';
import { DeleteAccountRequestReplyDTO } from '../../models/DeleteAccountRequestReplyDTO';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { UsersService } from '../../services/userService/users.service';

@Component({
  selector: 'app-delete-account-requests',
  templateUrl: './delete-account-requests.component.html',
  styleUrls: ['./delete-account-requests.component.css']
})
export class DeleteAccountRequestsComponent implements OnInit {
  requests : DeleteAccountRequest[];
  replyMode : boolean = false;
  description : string = "";
  selectedRequest : DeleteAccountRequest;

  constructor(private userService : UsersService,private rentingItemService : RentingItemsService,
    private authService : AuthService) { }
  

  ngOnInit(): void {
    this.load();
  }

  load(){
    this.userService.getAllDeleteAccountRequests().subscribe( res => {
        this.requests = res;
        for( let i = 0 ; i < this.requests.length; i++){
          this.userService.getClientById(this.requests[i].clientId).subscribe( res => {
            this.requests[i].client = res;
            this.requests[i].solved = false;
          });
        }
    });
    console.log(this.requests);
  }

  turnReplyModeOn(selectedComplaint : any){
    this.replyMode = true;
    this.selectedRequest = selectedComplaint;
  }

  turnReplyModeOff(){
    this.replyMode = false;
  }

  denyRequest(){
    var requestReply = new DeleteAccountRequestReplyDTO(this.selectedRequest.id,this.description,this.selectedRequest.clientId);
    this.userService.denyDeleteAccountRequest(requestReply).subscribe( res => {
      alert("Successfully replied to request.")
      this.replyMode = false;
    },
    error => {
      alert("Something went wrong")
    })
  }

  approveRequest(request : DeleteAccountRequest){
    var requestReply = new DeleteAccountRequestReplyDTO(request.id,this.description,request.clientId);
    this.userService.approveDeleteAccountRequest(requestReply).subscribe( res => {
      alert("Successfully replied to request.")
      this.load();
    },
    error => {
      alert("Something went wrong")
    })
  }

  logOut(){
    this.authService.logout();
  }


}
