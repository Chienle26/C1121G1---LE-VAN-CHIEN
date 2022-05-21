import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Customer} from '../../../model/customer';
import {CustomersService} from '../../../service/customers.service';
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
  p = 1;
  nameSearch = '';
  number = 0;
  totalPages = 0;

  constructor(private customersService: CustomersService) {
  }

  ngOnInit(): void {
    this.getAllCustomers();
  }


  getAllCustomers() {
    this.customersService.getCustomersPage(this.number).subscribe((customers) => {
        this.customers = customers.content;
        this.number = customers.number;
        this.totalPages = customers.totalPages;
      }, err => console.log(err)
    );
  }

  next() {
    if (this.number < this.totalPages - 1) {
      this.customersService.getCustomersPage(this.number + 1).subscribe(
        customers => {
          this.customers = customers.content;
          this.number = customers.number;
          console.log(customers);
        }, err => console.log(err)
      );
    }

  }

  previous() {
    if (this.number > 0) {
      this.customersService.getCustomersPage(this.number - 1).subscribe(
        customers => {
          this.customers = customers.content;
          this.number = customers.number;
          console.log(customers);
        }, err => console.log(err)
      );
    }
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

  search() {
    if (this.nameSearch === ''){
      this.ngOnInit();
    } else {
      this.customers = this.customers.filter(res => {
        return res.customerName.toLocaleLowerCase().match(this.nameSearch.toLocaleLowerCase());
      });
    }
  }

}
