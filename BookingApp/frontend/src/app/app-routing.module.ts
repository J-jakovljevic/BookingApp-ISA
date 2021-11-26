import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientRegistrationComponent } from './shared/components/client-registration/client-registration.component';
import { HomePageComponent } from './shared/components/home-page/home-page.component';


const routes: Routes = [
  {
    path : 'homepage',
    component : HomePageComponent,
  },
  {
    path : 'clientRegistration',
    component : ClientRegistrationComponent,
  }
];

@NgModule({
  declarations: [],
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
