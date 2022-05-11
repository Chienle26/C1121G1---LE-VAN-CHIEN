import { Component, OnInit } from '@angular/core';
import {Contract} from '../model/contract';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  contracts: Contract[] = [
    {
      contractId: 1,
      contractStartDate: '2020-12-08',
      contractEndDate: '2020-12-08',
      contractDeposit: 1000,
      contractTotalMoney: 1000000,
      employeeId: 3,
      customer: {
        customerId: 1,

        customerCode: 'KH-0001',

        customerName: 'Nguyễn Thị Hào',

        customerBirthday: '1970-11-07',

        customerGender: '0',

        customerIdCard: '643431213',

        customerPhone: '0905423362',

        customerEmail: 'thihao07@gmail.com',

        customerAddress: '23 Nguyễn Hoàng, Đà Nẵng',

        customerTypeId: 5,
      },
      services: {
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
        serviceType: 3,
      }
    },
    {
      contractId: 2,
      contractStartDate: '2020-07-14',
      contractEndDate: '2020-07-21',
      contractDeposit: 200000,
      contractTotalMoney: 2000000,
      employeeId: 7,
      customer: {
        customerId: 3,

        customerCode: 'KH-0003',

        customerName: 'Trương Đình Nghệ',

        customerBirthday: '1990-02-27',

        customerGender: '1',

        customerIdCard: '488645199',

        customerPhone: '0373213122',

        customerEmail: 'nghenhan2702@gmail.com',

        customerAddress: 'K323/12 Ông Ích Khiêm, Vinh',

        customerTypeId: 3,
      },
      services: {
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
        rentType: 2,
        serviceType: 1,
      }
    },
    {
      contractId: 3,
      contractStartDate: '2021-03-15',
      contractEndDate: '2021-03-17',
      contractDeposit: 50000,
      contractTotalMoney: 1500000,
      employeeId: 3,
      customer: {
        customerId: 4,

        customerCode: 'KH-0004',

        customerName: 'Dương Văn Quan',

        customerBirthday: '1981-07-08',

        customerGender: '1',

        customerIdCard: '543432111',

        customerPhone: '0490039241',

        customerEmail: 'duongquan@gmail.com',

        customerAddress: 'K453/12 Lê Lợi, Đà Nẵng',

        customerTypeId: 2,
      },
      services: {
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
        rentType: 3,
        serviceType: 2,
      }
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
