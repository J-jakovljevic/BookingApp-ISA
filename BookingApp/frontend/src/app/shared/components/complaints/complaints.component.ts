import { Component, OnInit } from '@angular/core';
import { Complaint } from '../../models/Complaint';
import { ComplaintReply } from '../../models/ComplaintReply';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { UsersService } from '../../services/userService/users.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {
  complaints : Complaint[];
  constructor(private userService : UsersService,private rentingItemService : RentingItemsService,
    private authService : AuthService) { }
  replyMode : boolean = false;
  description : string;
  selectedComplaint : Complaint;

  ngOnInit(): void {
    this.loadComplaints();
  }

  loadComplaints(){
    this.userService.getAllComplaints().subscribe( res => {
        this.complaints = res;
        for( let i = 0 ; i < this.complaints.length; i++){
          this.rentingItemService.getRentingItemById(this.complaints[i].rentingItemId).subscribe( res => {
            this.complaints[i].rentingItem = res;
          });
          this.userService.getClientById(this.complaints[i].clientId).subscribe( res => {
            this.complaints[i].client = res;
          });
        }
    });
    console.log(this.complaints);
  }

  turnReplyModeOn(selectedComplaint : any){
    this.replyMode = true;
    this.selectedComplaint = selectedComplaint;
  }

  turnReplyModeOff(){
    this.replyMode = false;
  }

  createComplaintReply(){
    var complaintReply = new ComplaintReply(0,this.selectedComplaint.clientId,this.selectedComplaint.rentingItemId,this.description);
    this.rentingItemService.createComplaintReply(complaintReply).subscribe( res => {
      alert("Successfully replied to complaint.")
      this.replyMode = false;
    },
    error => {
      alert("Something went wrong")
    })
  }

  logOut(){
    this.authService.logout();
  }

 
}
