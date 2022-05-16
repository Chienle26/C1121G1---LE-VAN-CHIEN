import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomersService} from '../service/customers.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  title = 'List Customer';
  customers: Customer[] = [];
  deleteCustomer: Customer;
  check = false;

  constructor(private customersService: CustomersService) {
  }

  ngOnInit(): void {
    this.getAllCustomers();
  }


  getAllCustomers() {
    this.customersService.getCustomers().subscribe((customers) => {
      this.customers = customers;
    }, error => {
      console.log(error);
    });
  }

  delete(event) {
    this.customersService.deleteCustomer( this.deleteCustomer.id).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, error => {
      console.log(error);
    });
  }

  onOpenEditModal(customerChooseDelete: Customer) {
    this.deleteCustomer = customerChooseDelete;
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
