import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthGuard } from './auth.guard';
import { ClientPenaltiesComponent } from './shared/components/client-penalties/client-penalties.component';
import { ClientProfileComponent } from './shared/components/client-profile/client-profile.component';
import { ClientRegistrationComponent } from './shared/components/client-registration/client-registration.component';
import { ClientReservationsComponent } from './shared/components/client-reservations/client-reservations.component';
import { ClientSubscriptionsComponent } from './shared/components/client-subscriptions/client-subscriptions.component';
import { ComplaintsComponent } from './shared/components/complaints/complaints.component';
import { DeleteAccountRequestsComponent } from './shared/components/delete-account-requests/delete-account-requests.component';
import { HomePageComponent } from './shared/components/home-page/home-page.component';
import { LoginComponent } from './shared/components/login/login.component';
import { LoyaltyProgramComponent } from './shared/components/loyalty-program/loyalty-program.component';
import { RentingItemReservationsComponent } from './shared/components/renting-item-reservations/renting-item-reservations.component';
import { RevisionsComponent } from './shared/components/revisions/revisions.component';
import { SystemAdminPageComponent } from './shared/components/system-admin-page/system-admin-page.component';
import { DeleteAccountRequest } from './shared/models/DeleteAccountRequest';
import { CottageOwnerProfileComponent } from './shared/components/cottage-owner-profile/cottage-owner-profile.component';
import { BoatOwnerProfileComponent } from './shared/components/boat-owner-profile/boat-owner-profile.component';
import { CottageOwnerCottagesComponent } from './shared/components/cottage-owner-cottages/cottage-owner-cottages.component';
import { CottageReservationsComponent } from './shared/components/cottage-reservations/cottage-reservations.component';
import { BoatOwnerBoatsComponent } from './shared/components/boat-owner-boats/boat-owner-boats.component';
import { BoatReservationsComponent } from './shared/components/boat-reservations/boat-reservations.component';

const routes: Routes = [
  {
    path : 'app',
    component : AppComponent,
  },
  {
    path : '',
    component : HomePageComponent,
  },
  {
    path : 'clientRegistration',
    component : ClientRegistrationComponent,
  },
  {
    path : 'login',
    component : LoginComponent,
  },
  {
    path : 'clientProfile',
    component : ClientProfileComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'Client'
    }
  },
  {
    path : 'clientReservations',
    component : ClientReservationsComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'Client'
    }
  },
  {
    path : 'clientSubscriptions',
    component : ClientSubscriptionsComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'Client'
    }
  },
  {
    path : 'clientPenalties',
    component : ClientPenaltiesComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'Client'
    }
  },
  {
    path : 'rentingItemReservations',
    component : RentingItemReservationsComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'Client'
    }
  },
  {
    path : 'systemAdminPage',
    component : SystemAdminPageComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'SystemAdmin'
    }
  },
  {
    path : 'revisions',
    component : RevisionsComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'SystemAdmin'
    }
  },
  {
    path : 'complaints',
    component : ComplaintsComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'SystemAdmin'
    }
  },
  {
    path : 'deleteAccountRequests',
    component : DeleteAccountRequestsComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'SystemAdmin'
    }
  },
  {
    path : 'loyaltyProgram',
    component : LoyaltyProgramComponent,
    canActivate: [AuthGuard],
    data: {
      role: 'SystemAdmin'
    }
  },
{
  path : 'cottageOwnerProfile',
  component : CottageOwnerProfileComponent,
  canActivate : [AuthGuard],
  data: {
    role: 'CottageOwner'
  }
},
{
  path : 'boatOwnerProfile',
  component : BoatOwnerProfileComponent,
  canActivate : [AuthGuard],
  data: {
    role: 'BoatOwner'
  }
},
{
  path : 'myCottages',
  component : CottageOwnerCottagesComponent,
  canActivate : [AuthGuard],
  data: {
    role: 'CottageOwner'
  }
},
{
  path : 'cottageReservations',
  component : CottageReservationsComponent,
  canActivate : [AuthGuard],
  data: {
    role: 'CottageOwner'
  }
},
{
  path : 'myBoats',
  component : BoatOwnerBoatsComponent,
  canActivate : [AuthGuard],
  data: {
    role: 'BoatOwner'
  }
},
{
  path : 'boatReservations',
  component : BoatReservationsComponent,
  canActivate : [AuthGuard],
  data: {
    role: 'BoatOwner'
  }
}


];

@NgModule({
  declarations: [],
    imports: [RouterModule.forRoot(routes,{onSameUrlNavigation:'reload'})],
    exports: [ RouterModule]
})
export class AppRoutingModule { }
