import { Component, OnInit } from '@angular/core';
import { Revision } from '../../models/Revision';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';

@Component({
  selector: 'app-revisions',
  templateUrl: './revisions.component.html',
  styleUrls: ['./revisions.component.css']
})
export class RevisionsComponent implements OnInit {
  unapprovedRevisions : Revision[];

  constructor(private authService : AuthService,private rentingItemService : RentingItemsService) { }

  ngOnInit(): void {
   this.loadUnapprovedRevisions();
  }

  logOut(){
    this.authService.logout();
  }

  loadUnapprovedRevisions(){
    this.rentingItemService.getAllUnapprovedRevisions().subscribe(res => {
      this.unapprovedRevisions = res;
      for(let i = 0;i < this.unapprovedRevisions.length ; i++){
        this.rentingItemService.getRentingItemById(this.unapprovedRevisions[i].rentingItemId).subscribe(res => {
            this.unapprovedRevisions[i].rentingItem = res;
        });
      }
    });
  }

  approveRevision(revisionId : any){
    this.rentingItemService.approveRevision(revisionId).subscribe(res => {
    this.loadUnapprovedRevisions();
    });
  }
  denyRevision(revisionId : any){
    this.rentingItemService.denyRevision(revisionId).subscribe(res => {
      this.loadUnapprovedRevisions();
      });
  }

}
