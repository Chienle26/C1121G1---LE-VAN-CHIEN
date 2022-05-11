import { Component, OnInit } from '@angular/core';
import {Customer} from '../model/customer';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [
    {
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
    {
      customerId: 2,

      customerCode: 'KH-0002',

      customerName: 'Phạm Xuân Diệu',

      customerBirthday: '1992-08-08',

      customerGender: '1',

      customerIdCard: '865342123',

      customerPhone: '0954333333',

      customerEmail: 'xuandieu92@gmail.com',

      customerAddress: 'K77/22 Thái Phiên, Quảng Trị',

      customerTypeId: 4,
    },
    {
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
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
