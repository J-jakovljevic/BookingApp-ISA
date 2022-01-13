import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AdditionalService } from '../../models/AdditionalService';
import { Reservation } from '../../models/Reservation';
import { RentingItemAvailability } from '../../models/reservations/RentingItemAvailability';
import { RentingItemQuery } from '../../models/reservations/RentingItemQuery';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemAvailabilityService } from '../../services/rentingItemAvailability/renting-item-availability.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';

@Component({
  selector: 'app-renting-item-reservations',
  templateUrl: './renting-item-reservations.component.html',
  styleUrls: ['./renting-item-reservations.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class RentingItemReservationsComponent implements OnInit {
  searchForm:FormGroup;
  searchResults : RentingItemAvailability[];
  showSearchResultDetails : boolean = false;
  selectedSearchResult : any;
  checkedAdditionalServices:AdditionalService[]=[];

  priceSortType : String;
  gradeSortType : String;

  constructor(private rentingItemAvailabilityService : RentingItemAvailabilityService,
    private rentingItemService : RentingItemsService,private reservationService:ReservationsService,
    private authService: AuthService) {

   }

  ngOnInit(): void {
    this.searchForm = new FormGroup({
      'capacity' : new FormControl(0,Validators.required),
      'startDate' : new FormControl(null, Validators.required),
      'endDate' :  new FormControl(null, Validators.required),
      'type' :  new FormControl(null, Validators.required),
      'grade' :  new FormControl(null),
      'location' :  new FormControl(null)
    });
  }

  searchRentingItems(){
    var rentingItemQuery = new RentingItemQuery(this.searchForm.value.startDate,this.searchForm.value.endDate,this.searchForm.value.capacity,
      this.searchForm.value.type,this.searchForm.value.location,this.searchForm.value.grade);
    this.rentingItemAvailabilityService.search(rentingItemQuery).subscribe(res =>{
      this.searchResults = res;
      for(let i=0;i<this.searchResults.length;i++){
        this.rentingItemService.getRentingItemById(this.searchResults[i].rentingItemId).subscribe(res1 =>{
          this.searchResults[i].rentingItem = res1;
          this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.searchResults[i].rentingItem.id).subscribe( res3 => {
            this.searchResults[i].rentingItem.additionalServices = res3;
          });
        });
        console.log(this.searchResults);
      }
    });
    
  }

  showSearchResultDetail(id:Number){
    this.checkedAdditionalServices = [];
    this.showSearchResultDetails = true;
    this.selectedSearchResult = this.searchResults.find(res => res.id = id);
   
  }
  unselectSearchResult(){
    this.showSearchResultDetails =false;
  }
  makeReservation(){
    var newReservation = new Reservation(0,this.authService.currentUser.user.id,this.selectedSearchResult.rentingItem.id,
      this.searchForm.value.startDate,this.searchForm.value.endDate,this.checkedAdditionalServices);
      console.log(newReservation);
      this.reservationService.createReservation(newReservation).subscribe(res =>{
        console.log(res);
        alert("Successfully reserved item!");
      });
      this.showSearchResultDetails = false;
      this.searchResults = [];
  }

  addAdditionalService(a : any){
    if(this.checkedAdditionalServices.find(aa => aa.id == a.id)){
      this.checkedAdditionalServices = this.checkedAdditionalServices.filter(aa=> aa.id != a.id);
    }
    else{
      this.checkedAdditionalServices.push(a);
    }
    
    console.log(this.checkedAdditionalServices);
  }

  logOut(){
    this.authService.logout();
  }

  sortByPrice(){
    if(this.priceSortType == 'Descending'){
      this.searchResults.sort((a : any, b : any) => b.price - a.price);
    }
    else{
      this.searchResults.sort((a : any, b : any) => a.price - b.price);
    }
  }

  sortByGrade(){
    if(this.gradeSortType == 'Descending'){
      this.searchResults.sort((a : any, b : any) => b.rentingItem.averageGrade - a.rentingItem.averageGrade);
    }
    else{
      this.searchResults.sort((a : any, b : any) => a.rentingItem.averageGrade - b.rentingItem.averageGrade);
    }
  }
}
