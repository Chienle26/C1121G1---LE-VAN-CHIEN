import {Component, OnInit} from '@angular/core';
import {Facility} from '../model/facility';
import {FacilitiesService} from '../service/facilities.service';

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  title = 'List Service';
  facilities: Facility[] = [];

  constructor(private facilitiesService: FacilitiesService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.facilities = this.facilitiesService.getFacilities();
  }
}
