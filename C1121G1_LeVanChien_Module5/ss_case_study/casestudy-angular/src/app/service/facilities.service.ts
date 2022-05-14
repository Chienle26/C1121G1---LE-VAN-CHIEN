import { Injectable } from '@angular/core';
import {Facility} from '../model/facility';

@Injectable({
  providedIn: 'root'
})
export class FacilitiesService {

  constructor() { }

  private facilities: Facility[] = [
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
      rentType: 2,
      serviceType: 2,
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
      rentType: 3,
      serviceType: 3,
    },
    {
      serviceId: 4,
      serviceCode: 'DV-0004',
      serviceName: 'Villa No Beach Front',
      serviceImage: 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg',
      serviceArea: 22000,
      serviceCost: 9000000,
      serviceMaxPeople: 8,
      standardRoom: 'normal',
      descriptionOtherConvenience: 'Có hồ bơi',
      poolArea: 300,
      numberOfFloors: 3,
      rentType: 2,
      serviceType: 1,
    },
    {
      serviceId: 5,
      serviceCode: 'DV-0005',
      serviceName: 'House Princess 02',
      serviceImage: 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg',
      serviceArea: 10000,
      serviceCost: 4000000,
      serviceMaxPeople: 5,
      standardRoom: 'normal',
      descriptionOtherConvenience: 'Có thêm bếp nướng',
      poolArea: 0,
      numberOfFloors: 2,
      rentType: 3,
      serviceType: 2,
    },
    {
      serviceId: 6,
      serviceCode: 'DV-0006',
      serviceName: 'Room Twin 02',
      serviceImage: 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg',
      serviceArea: 3000,
      serviceCost: 900000,
      serviceMaxPeople: 2,
      standardRoom: 'normal',
      descriptionOtherConvenience: 'Có tivi',
      poolArea: 0,
      numberOfFloors: 0,
      rentType: 1,
      serviceType: 3,
    }
  ];

  public getFacilities(){
    return this.facilities;
  }
}
