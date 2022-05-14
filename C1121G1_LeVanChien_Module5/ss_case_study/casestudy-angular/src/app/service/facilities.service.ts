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
      serviceArea: 250,
      serviceCost: 1500,
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
      serviceImage: 'https://tbb-prod-apac.imgix.net/attachments/room_type_photos/images/723995/723995/DSC_0693.jpg?auto=format,compress&fit=crop&crop=entropy&w=300&h=200&q=55',
      serviceArea: 140,
      serviceCost: 1000,
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
      serviceArea: 50,
      serviceCost: 500,
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
      serviceImage: 'https://tbb-prod-apac.imgix.net/attachments/room_type_photos/images/724012/724012/Ocean_Studio_Suite_-_Overall.JPG?auto=format,compress&fit=crop&crop=entropy&w=300&h=200&q=55',
      serviceArea: 220,
      serviceCost: 1900,
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
      serviceArea: 200,
      serviceCost: 1000,
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
      serviceImage: 'https://tbb-prod-apac.imgix.net/attachments/room_type_photos/images/724012/724012/Ocean_Studio_Suite_-_Overall.JPG?auto=format,compress&fit=crop&crop=entropy&w=300&h=200&q=55',
      serviceArea: 70,
      serviceCost: 900,
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
