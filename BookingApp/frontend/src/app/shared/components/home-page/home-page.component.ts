import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Boat } from '../../models/Boat';
import { Client } from '../../models/Client';
import { Cottage } from '../../models/Cottage';
import { CreateSubscriptionDTO } from '../../models/CreateSubscriptionDTO';
import { FishingInstructorClass } from '../../models/FishingInstructorClass';
import { RentingItem } from '../../models/reservations/RentingItem';
import { Subscription } from '../../models/Subscription';
import { FishingInstructor } from '../../models/users/FishingInstructor';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { SubscriptionsService } from '../../services/subscriptions/subscriptions.service';
import { UsersService } from '../../services/userService/users.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomePageComponent implements OnInit {
  selectedTab: string;
  allBoats : Boat[];
  allFishingInstructorClasses : FishingInstructorClass[];
  allFishingInstructors : FishingInstructor[];
  allCottages : Cottage[];
  cottageSelected : boolean = false;
  selectedCottage : any;
  boatSelected : boolean = false;
  selectedBoat : any;
  fishingInstructorClassSelected : boolean = false;
  selectedFishingInstructorClass : any;
  fishingInstructor : FishingInstructor;
  fishingInstructorsSelected : boolean = false;
  selectedFishingInstructor : any;
  searchInput : String;
 

  constructor(private rentingItemsService : RentingItemsService, 
    private usersService : UsersService,private authService: AuthService,
    private subscriptionService : SubscriptionsService) { }

  ngOnInit(): void {
    this.getAllBoats();
    this.getAllCottages();
    this.getAllFishingInstructorClasses();
    this.getAllFishingInstructors();
  }

  selectionChanged(selectedItem : string): void{
    this.selectedTab = selectedItem;
  }

  getAllBoats() : void{
    this.rentingItemsService.getAllBoats().subscribe(res => {
      this.allBoats = res;
    });
  }

  getAllFishingInstructorClasses() : void{
    this.rentingItemsService.getAllFishingInstructorClass().subscribe(res => {
      this.allFishingInstructorClasses = res;
    });
  }

  getAllCottages() : void{
    this.rentingItemsService.getAllCottages().subscribe(res => {
      this.allCottages = res;
    });
  }

  getAllFishingInstructors() : void{
    this.usersService.getAllFishingInstructors().subscribe(res => {
      this.allFishingInstructors = res;
      console.log(res);
    });
  }


  showCottageDetails(id: Number): void{
    this.cottageSelected = true;
    this.selectedCottage = this.allCottages.find(cottage => cottage.id == id);
  }

  unselectCottage() : void{
    this.cottageSelected = false;
  }

  showBoatDetails(id: Number): void{
    this.boatSelected = true;
    this.selectedBoat = this.allBoats.find(boat => boat.id == id);
  }

  unselectBoat() : void{
    this.boatSelected = false;
  }

  showFishingInstructorClassDetails(id: Number): void{
    this.fishingInstructorClassSelected = true;
    this.selectedFishingInstructorClass = this.allFishingInstructorClasses.find(fishingInstructorClass => fishingInstructorClass.id == id);
    this.usersService.getFishingInstructorById(this.selectedFishingInstructorClass.fishingInstructorId).subscribe(res => {
      this.fishingInstructor = res;
    });
  }

  unselectFishingInstructorClass() : void{
    this.fishingInstructorClassSelected = false;
  }

  searchCottages() : void{
    if(this.searchInput == ''){
      this.getAllCottages();
    }
    else{
      console.log(this.searchInput);
      this.rentingItemsService.searchCottages(this.searchInput).subscribe( res => {
          this.allCottages = res;
      });
    }
  }

  searchFishingInstructorClasses() : void{
    if(this.searchInput == ''){
      this.getAllFishingInstructorClasses();
    }
    else{
      console.log(this.searchInput);
      this.rentingItemsService.searchFishingInstructorClasses(this.searchInput).subscribe( res => {
          this.allFishingInstructorClasses = res;
      });
    }
  }

  searchFishingInstructors() : void{
    if(this.searchInput == ''){
      this.getAllFishingInstructors();
    }
    else{
      console.log(this.searchInput);
      this.usersService.searchFishingInstructors(this.searchInput).subscribe( res => {
          this.allFishingInstructors = res;
      });
    }
  }


  searchBoats() : void{
    if(this.searchInput == ''){
      this.getAllBoats();
    }
    else{
      console.log(this.searchInput);
      this.rentingItemsService.searchBoats(this.searchInput).subscribe( res => {
          this.allBoats = res;
      });
    }
  }

  showFishingInstructorDetails(id: Number): void{
    this.fishingInstructorsSelected = true;
    this.selectedFishingInstructor = this.allFishingInstructors.find(f => f.id == id);
    console.log(this.selectedFishingInstructor);
  }

  unselectFishingInstructor() : void{
    this.fishingInstructorsSelected = false;
  }

  logOut() : void {
    this.authService.logout();
  }

  isUnauthenticatedUser() : boolean{
    return localStorage.getItem('ROLE') == '';
  }
  isClient() : boolean{
    return localStorage.getItem('ROLE') == 'Client';
  }

  subscribe(rentingItemId : any){
     var newSubscription = new CreateSubscriptionDTO(0,rentingItemId,this.authService.currentUser.user.id);
     this.subscriptionService.subscribe(newSubscription).subscribe(res =>{
       alert("Successfully subscribed to item!");
     })
  }

}
