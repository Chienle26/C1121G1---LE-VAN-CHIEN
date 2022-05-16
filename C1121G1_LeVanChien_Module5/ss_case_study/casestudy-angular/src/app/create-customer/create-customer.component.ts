import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  title = 'Create Customer';
  customerForm = new FormGroup({
    customerCode: new FormControl('', [Validators.required, Validators.pattern('^$|^KH-[\\d]{4}$')]),
    customerName: new FormControl('', [Validators.required, Validators.pattern('^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$')]),
    customerBirthday: new FormControl('', Validators.required),
    customerGender: new FormControl('', Validators.required),
    customerIdCard: new FormControl('', [Validators.required, Validators.pattern('^$|^\\d{9}$')]),
    customerPhone: new FormControl('', [Validators.required, Validators.pattern('^((090)|(091)|(\\+8490)|(\\+8491))\\d{7}$')]),
    customerEmail: new FormControl('', [Validators.required, Validators.email]),
    customerAddress: new FormControl('', Validators.required),
    customerTypeId: new FormControl('', Validators.required)
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.customerForm);

    if (this.customerForm.invalid) {
      if (this.customerForm.controls.customerCode.value == '') {
        this.customerForm.controls.customerCode.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerName.value == '') {
        this.customerForm.controls.customerName.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerBirthday.value == '') {
        this.customerForm.controls.customerBirthday.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerGender.value == null) {
        this.customerForm.controls.customerGender.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerIdCard.value == '') {
        this.customerForm.controls.customerIdCard.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerPhone.value == '') {
        this.customerForm.controls.customerPhone.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerEmail.value == '') {
        this.customerForm.controls.customerEmail.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerAddress.value == '') {
        this.customerForm.controls.customerAddress.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerForm.controls.customerTypeId.value == '') {
        this.customerForm.controls.customerTypeId.setErrors({empty: 'Empty! Please input!'});
      }
    }
  }
}
