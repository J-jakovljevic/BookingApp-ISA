import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ClientRegistrationComponent } from './components/client-registration/client-registration.component';
import { LoginComponent } from './components/login/login.component';
import { ClientProfileComponent } from './components/client-profile/client-profile.component';
import { ClientReservationsComponent } from './components/client-reservations/client-reservations.component';



@NgModule({
  declarations: [
    NavbarComponent,
    HomePageComponent,
    ClientRegistrationComponent,
    LoginComponent,
    ClientProfileComponent,
    ClientReservationsComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    NavbarComponent,
    HomePageComponent,
    ClientRegistrationComponent,
    LoginComponent,
    ClientProfileComponent,
    ClientReservationsComponent
  ]
})
export class SharedModule { }
