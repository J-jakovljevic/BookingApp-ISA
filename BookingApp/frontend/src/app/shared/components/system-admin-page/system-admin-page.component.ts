import { Component, OnInit } from '@angular/core';
import { Revision } from '../../models/Revision';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';

@Component({
  selector: 'app-system-admin-page',
  templateUrl: './system-admin-page.component.html',
  styleUrls: ['./system-admin-page.component.css']
})
export class SystemAdminPageComponent implements OnInit {
  constructor(private authService : AuthService) { }

  ngOnInit(): void {}

  logOut(){
    this.authService.logout();
  }
}