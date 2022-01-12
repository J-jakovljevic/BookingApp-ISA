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
import { HomePageComponent } from './shared/components/home-page/home-page.component';
import { LoginComponent } from './shared/components/login/login.component';
import { RentingItemReservationsComponent } from './shared/components/renting-item-reservations/renting-item-reservations.component';
import { SystemAdminPageComponent } from './shared/components/system-admin-page/system-admin-page.component';


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
  }
];

@NgModule({
  declarations: [],
    imports: [RouterModule.forRoot(routes,{onSameUrlNavigation:'reload'})],
    exports: [ RouterModule]
})
export class AppRoutingModule { }
