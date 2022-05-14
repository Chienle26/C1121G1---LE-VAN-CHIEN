import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomersService} from '../service/customers.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  title = 'List Customer';
  customers: Customer[] = [];
  constructor(private customersService: CustomersService) { }

  ngOnInit(): void {
   this.getAllCustomers();
  }


  getAllCustomers(){
    this.customers = this.customersService.getCustomers();
  }

}
