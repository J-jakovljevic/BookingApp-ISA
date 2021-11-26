import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ClientRegistrationComponent } from './components/client-registration/client-registration.component';



@NgModule({
  declarations: [
    NavbarComponent,
    HomePageComponent,
    ClientRegistrationComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    NavbarComponent,
    HomePageComponent,
    ClientRegistrationComponent
  ]
})
export class SharedModule { }
