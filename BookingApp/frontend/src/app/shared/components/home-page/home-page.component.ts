import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from '../../models/Boat';
import { Cottage } from '../../models/Cottage';
import { FishingInstructorClass } from '../../models/FishingInstructorClass';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';

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


  constructor(private rentingItemsService : RentingItemsService) { }

  ngOnInit(): void {
  }

  selectionChanged(selectedItem : string): void{
    this.selectedTab = selectedItem;
    if(selectedItem == 'Boats'){
      this.getAllBoats();
    }
    else if(selectedItem == 'Cottages'){
      this.getAllCottages();
    }
    else{
      this.getAllFishingInstructorClasses();
    }
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

}
