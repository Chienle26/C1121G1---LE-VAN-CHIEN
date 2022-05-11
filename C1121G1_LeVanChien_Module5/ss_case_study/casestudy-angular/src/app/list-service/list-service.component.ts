import { Component, OnInit } from '@angular/core';
import {Facility} from '../model/facility';

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  facilities: Facility[] = [
    {
      serviceId: 1,
      serviceCode: 'DV-0001',
      serviceName: 'Villa Beach Front',
      serviceImage: 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg',
      serviceArea: 25000,
      serviceCost: 10000000,
      serviceMaxPeople: 10,
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Có hồ bơi',
      poolArea: 500,
      numberOfFloors: 4,
      rentType: 1,
      serviceType: 1,
    },
    {
      serviceId: 2,
      serviceCode: 'DV-0002',
      serviceName: 'House Princess 01',
      serviceImage: 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg',
      serviceArea: 14000,
      serviceCost: 5000000,
      serviceMaxPeople: 7,
      standardRoom: 'vip',
      descriptionOtherConvenience: 'Có thêm bếp nướng',
      poolArea: 0,
      numberOfFloors: 3,
      rentType: 1,
      serviceType: 2
    },
    {
      serviceId: 3,
      serviceCode: 'DV-0003',
      serviceName: 'Room Twin 01',
      serviceImage: 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg',
      serviceArea: 5000,
      serviceCost: 1000000,
      serviceMaxPeople: 2,
      standardRoom: 'normal',
      descriptionOtherConvenience: 'Có tivi',
      poolArea: 0,
      numberOfFloors: 0,
      rentType: 1,
      serviceType: 3
    }
    ];
  constructor() { }

  ngOnInit(): void {
  }

}
