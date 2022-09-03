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
import { SystemAdminPageComponent } from './components/system-admin-page/system-admin-page.component';
import { ComplaintsComponent } from './components/complaints/complaints.component';
import { RevisionsComponent } from './components/revisions/revisions.component';
import { DeleteAccountRequestsComponent } from './components/delete-account-requests/delete-account-requests.component';
import { LoyaltyProgramComponent } from './components/loyalty-program/loyalty-program.component';
import { CottageOwnerProfileComponent } from './components/cottage-owner-profile/cottage-owner-profile.component';
import { BoatOwnerProfileComponent } from './components/boat-owner-profile/boat-owner-profile.component';
import { CottageOwnerCottagesComponent } from './components/cottage-owner-cottages/cottage-owner-cottages.component';
import { CottageReservationsComponent } from './components/cottage-reservations/cottage-reservations.component';
import { BoatOwnerBoatsComponent } from './components/boat-owner-boats/boat-owner-boats.component';
import { BoatReservationsComponent } from './components/boat-reservations/boat-reservations.component';


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
    RentingItemReservationsComponent,
    SystemAdminPageComponent,
    ComplaintsComponent,
    RevisionsComponent,
    DeleteAccountRequestsComponent,
    LoyaltyProgramComponent,
    CottageOwnerProfileComponent,
    BoatOwnerProfileComponent,
    CottageOwnerCottagesComponent,
    CottageReservationsComponent,
    BoatOwnerBoatsComponent,
    BoatReservationsComponent
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
    RentingItemReservationsComponent,
    CottageOwnerProfileComponent,
    BoatOwnerProfileComponent,
    CottageReservationsComponent
  ]
})
export class SharedModule { }