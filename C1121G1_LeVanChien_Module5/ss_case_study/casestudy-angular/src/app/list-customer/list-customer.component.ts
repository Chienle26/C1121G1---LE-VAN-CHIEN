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
  constructor(private customersService: CustomersService) { }

  ngOnInit(): void {
   this.getAllCustomers();
  }


  getAllCustomers(){
    this.customers = this.customersService.getCustomers();
  }

  onOpenEditModal(a: Customer) {
    console.log('hhhhhh');
    this.deleteCustomer = a;
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

  // delete(closeModal: HTMLButtonElement) {
  //   this.customersService.deleteCustomer(this.deleteCustomer).subscribe((res: void) => {
  //     closeModal.click();
  //     this.ngOnInit();
  //
  //   }, (error: HttpErrorResponse) => {
  //     alert('sai rồi');
  //   });
  // }
  //
  // onDeleteCustomer(customerId: number) {
  //   this.customersService.deleteCustomer(this.deleteCustomer).subscribe((res: void) => {
  //         closeModal.click();
  //         this.ngOnInit();
  //
  //       }, (error: HttpErrorResponse) => {
  //         alert('sai rồi');
  //       });
  // }
}
