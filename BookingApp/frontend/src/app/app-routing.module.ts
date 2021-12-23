import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ClientPenaltiesComponent } from './shared/components/client-penalties/client-penalties.component';
import { ClientProfileComponent } from './shared/components/client-profile/client-profile.component';
import { ClientRegistrationComponent } from './shared/components/client-registration/client-registration.component';
import { ClientReservationsComponent } from './shared/components/client-reservations/client-reservations.component';
import { ClientSubscriptionsComponent } from './shared/components/client-subscriptions/client-subscriptions.component';
import { HomePageComponent } from './shared/components/home-page/home-page.component';
import { LoginComponent } from './shared/components/login/login.component';
import { NavbarComponent } from './shared/components/navbar/navbar.component';


const routes: Routes = [
  {
    path : 'app',
    component : AppComponent,
  },
  {
    path : 'homepage',
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
  },
  {
    path : 'clientReservations',
    component : ClientReservationsComponent,
  },
  {
    path : 'navbar',
    component : NavbarComponent,
  },
  {
    path : 'clientSubscriptions',
    component : ClientSubscriptionsComponent,
  },
  {
    path : 'clientPenalties',
    component : ClientPenaltiesComponent,
  }
];

@NgModule({
  declarations: [],
    imports: [RouterModule.forRoot(routes,{onSameUrlNavigation:'reload'})],
    exports: [ RouterModule]
})
export class AppRoutingModule { }
