import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from '../../models/Boat';
import { Cottage } from '../../models/Cottage';
import { FishingInstructorClass } from '../../models/FishingInstructorClass';
import { FishingInstructor } from '../../models/users/FishingInstructor';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
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
  allCottages : Cottage[];
  cottageSelected : boolean = false;
  selectedCottage : any;
  boatSelected : boolean = false;
  selectedBoat : any;
  fishingInstructorClassSelected : boolean = false;
  selectedFishingInstructorClass : any;
  fishingInstructor : FishingInstructor;
  searchInput : String;
 

  constructor(private rentingItemsService : RentingItemsService, private usersService : UsersService) { }

  ngOnInit(): void {
    this.getAllBoats();
    this.getAllCottages();
    this.getAllFishingInstructorClasses();
  }

  selectionChanged(selectedItem : string): void{
    this.selectedTab = selectedItem;
  }

  getAllBoats() : void{
    this.rentingItemsService.getAllBoats().subscribe(res => {
      this.allBoats = res;
      console.log(res);
    });
  }

  getAllFishingInstructorClasses() : void{
    this.rentingItemsService.getAllFishingInstructorClass().subscribe(res => {
      this.allFishingInstructorClasses = res;
      console.log(res);
    });
  }

  getAllCottages() : void{
    this.rentingItemsService.getAllCottages().subscribe(res => {
      this.allCottages = res;
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

}
