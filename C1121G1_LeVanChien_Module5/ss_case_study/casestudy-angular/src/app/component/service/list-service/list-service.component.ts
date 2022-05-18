import {Component, OnInit} from '@angular/core';
import {Facility} from '../../../model/facility';
import {FacilitiesService} from '../../../service/facilities.service';

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  title = 'List Service';
  facilityApi = 'http://localhost:3000/service';
  facilities: Facility[] = [];
  deleteFacility: Facility;
  check = false;

  constructor(private facilitiesService: FacilitiesService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.facilitiesService.getFacilities().subscribe((facilities) => {
      this.facilities = facilities;
    }, error => {
      console.log(error);
    });
  }

  delete(event) {
    this.facilitiesService.deleteFacility( this.deleteFacility.id).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, error => {
      console.log(error);
    });
  }

  onOpenEditModal(facilityChooseDelete: Facility) {
    this.deleteFacility = facilityChooseDelete;
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#deleteModal');
    container.appendChild(button);
    this.check = true;
    button.click();
  }
}
