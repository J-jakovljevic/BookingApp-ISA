import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule} from '@angular/router';
import { CommonModule } from '@angular/common';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { MatListModule} from '@angular/material/list';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
import {MatRadioModule} from '@angular/material/radio';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ClientRegistrationComponent } from './shared/components/client-registration/client-registration.component';
import { HomePageComponent } from './shared/components/home-page/home-page.component';
import { LoginComponent } from './shared/components/login/login.component';
import { ClientProfileComponent } from './shared/components/client-profile/client-profile.component';
import { AuthInterceptorService } from './shared/services/authInterceptor/auth-interceptor.service';
import { ClientReservationsComponent } from './shared/components/client-reservations/client-reservations.component';
import { StoreModule } from '@ngrx/store';
import { RoleReducer } from './shared/reducers/RoleReducer';
import { ClientSubscriptionsComponent } from './shared/components/client-subscriptions/client-subscriptions.component';
import { ClientPenaltiesComponent } from './shared/components/client-penalties/client-penalties.component';
import { RentingItemReservationsComponent } from './shared/components/renting-item-reservations/renting-item-reservations.component';
import { SystemAdminPageComponent } from './shared/components/system-admin-page/system-admin-page.component';
import { RevisionsComponent } from './shared/components/revisions/revisions.component';
import { ComplaintsComponent } from './shared/components/complaints/complaints.component';
import { DeleteAccountRequest } from './shared/models/DeleteAccountRequest';
import { DeleteAccountRequestsComponent } from './shared/components/delete-account-requests/delete-account-requests.component';
import { LoyaltyProgramComponent } from './shared/components/loyalty-program/loyalty-program.component';
import { CottageOwnerProfileComponent } from './shared/components/cottage-owner-profile/cottage-owner-profile.component';
import { BoatOwnerProfileComponent } from './shared/components/boat-owner-profile/boat-owner-profile.component';
import { CottageOwnerCottagesComponent } from './shared/components/cottage-owner-cottages/cottage-owner-cottages.component';
import { CottageReservationsComponent } from './shared/components/cottage-reservations/cottage-reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientRegistrationComponent,
    HomePageComponent,
    LoginComponent,
    ClientProfileComponent,
    ClientReservationsComponent,
    ClientSubscriptionsComponent,
    ClientPenaltiesComponent,
    RentingItemReservationsComponent,
    SystemAdminPageComponent,
    RevisionsComponent,
    ComplaintsComponent,
    DeleteAccountRequestsComponent,
    LoyaltyProgramComponent,
    CottageOwnerProfileComponent,
    BoatOwnerProfileComponent,
    CottageOwnerCottagesComponent,
    CottageReservationsComponent
  ],
  imports: [
    RouterModule,
    CommonModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatDividerModule,
    MatButtonModule,
    MatDatepickerModule,
    MatRadioModule,
    MatTableModule,
    MatIconModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatMenuModule,
    MatCardModule,
    MatListModule,
    MatToolbarModule,
    MatSidenavModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    StoreModule.forRoot({role : RoleReducer})
  ],
  entryComponents: [
    LoginComponent
  ],
  providers: [ {
    provide : HTTP_INTERCEPTORS,
    useClass: AuthInterceptorService,
    multi   : true,
  },],
  bootstrap: [AppComponent]
})
export class AppModule { }
