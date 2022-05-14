import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  constructor() { }

  private customers: Customer[] = [
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

    },
    {
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
    {
      customerId: 5,

      customerCode: 'KH-0005',

      customerName: 'Hoàng Trần Nhi Nhi',

      customerBirthday: '1995-12-09',

      customerGender: '0',

      customerIdCard: '795453345',

      customerPhone: '0312345678',

      customerEmail: 'nhinhi123@gmail.com',

      customerAddress: '224 Lý Thái Tổ, Gia Lai',

      customerTypeId: 1,

    },
    {
      customerId: 6,

      customerCode: 'KH-0006',

      customerName: 'Tôn Nữ Mộc Châu',

      customerBirthday: '2005-12-06',

      customerGender: '0',

      customerIdCard: '732434215',

      customerPhone: '0988888844',

      customerEmail: 'thihao07@gmail.com',

      customerAddress: '23 Nguyễn Hoàng, Đà Nẵng',

      customerTypeId: 5,

    },
    {
      customerId: 7,

      customerCode: 'KH-0007',

      customerName: 'Nguyễn Mỹ Kim',

      customerBirthday: '1984-04-08',

      customerGender: '0',

      customerIdCard: '856453123',

      customerPhone: '0912345698',

      customerEmail: 'thihao07@gmail.com',

      customerAddress: '23 Nguyễn Hoàng, Đà Nẵng',

      customerTypeId: 4,

    },
    {
      customerId: 8,

      customerCode: 'KH-0008',

      customerName: 'Nguyễn Thị Hào',

      customerBirthday: '1999-04-08',

      customerGender: '0',

      customerIdCard: '965656433',

      customerPhone: '0763212345',

      customerEmail: 'thihao07@gmail.com',

      customerAddress: '23 Nguyễn Hoàng, Đà Nẵng',

      customerTypeId: 3,

    },
    {
      customerId: 9,

      customerCode: 'KH-0009',

      customerName: 'Trần Đại Danh',

      customerBirthday: '1994-07-01',

      customerGender: '1',

      customerIdCard: '432341235',

      customerPhone: '0643343433',

      customerEmail: 'thihao07@gmail.com',

      customerAddress: '23 Nguyễn Hoàng, Đà Nẵng',

      customerTypeId: 2,

    },
    {
      customerId: 10,

      customerCode: 'KH-0010',

      customerName: 'Nguyễn Tâm Đắc',

      customerBirthday: '1989-07-01',

      customerGender: '1',

      customerIdCard: '344343432',

      customerPhone: '0987654321',

      customerEmail: 'thihao07@gmail.com',

      customerAddress: '23 Nguyễn Hoàng, Đà Nẵng',

      customerTypeId: 1,

    }
  ];

  public getCustomers() {
    return this.customers;
  }
}