import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { LoginRequest } from '../../models/LoginRequest';
import { Role } from '../../models/users/Role';
import { AuthService } from '../../services/authService/auth.service';
import { DataService } from '../../services/data/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class LoginComponent implements OnInit {
  username : String;
  password : String;

  constructor(private authService : AuthService, private router: Router,private dataService: DataService) { }

  ngOnInit(): void {
  }

  login() : void {
    this.authService.login(new LoginRequest(this.username,this.password)).subscribe(res => {
      if(res.user.role == Role.Client){
        this.dataService.notifyAboutChange();
      }
    });
    
  }
  

}
