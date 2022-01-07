import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ClientRegistrationComponent } from './components/client-registration/client-registration.component';
import { LoginComponent } from './components/login/login.component';
import { ClientProfileComponent } from './components/client-profile/client-profile.component';
import { ClientReservationsComponent } from './components/client-reservations/client-reservations.component';
import { ClientSubscriptionsComponent } from './components/client-subscriptions/client-subscriptions.component';
import { ClientComplaintComponent } from './components/client-complaint/client-complaint.component';
import { ClientPenaltiesComponent } from './components/client-penalties/client-penalties.component';
import { RentingItemReservationsComponent } from './components/renting-item-reservations/renting-item-reservations.component';



@NgModule({
  declarations: [
    NavbarComponent,
    HomePageComponent,
    ClientRegistrationComponent,
    LoginComponent,
    ClientProfileComponent,
    ClientReservationsComponent,
    ClientSubscriptionsComponent,
    ClientComplaintComponent,
    ClientPenaltiesComponent,
    RentingItemReservationsComponent
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
    ClientReservationsComponent,
    ClientSubscriptionsComponent,
    ClientComplaintComponent,
    ClientPenaltiesComponent,
    RentingItemReservationsComponent
  ]
})
export class SharedModule { }
