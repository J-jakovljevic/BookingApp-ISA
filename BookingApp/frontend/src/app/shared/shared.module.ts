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
    LoyaltyProgramComponent
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
