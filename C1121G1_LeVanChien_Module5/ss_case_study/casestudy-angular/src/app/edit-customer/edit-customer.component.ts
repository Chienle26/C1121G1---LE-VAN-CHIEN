import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  title = 'Edit Customer';
  editCustomerForm = new FormGroup({
    customerId: new FormControl(''),
    customerCode: new FormControl('KH-0001', [Validators.required, Validators.pattern('^$|^KH-[\\d]{4}$')]),
    customerName: new FormControl('Lê Văn Chiến', Validators.required),
    customerBirthday: new FormControl('1997-08-26', Validators.required),
    customerGender: new FormControl('1', Validators.required),
    customerIdCard: new FormControl('123456789', [Validators.required, Validators.pattern('^$|^\\d{9}$')]),
    customerPhone: new FormControl('0708313527', [Validators.required, Validators.pattern('^$|^(0|\\(84\\)\\+)9[0|1]\\d{7}$')]),
    customerEmail: new FormControl('chienle26@gmail.com', [Validators.required, Validators.email]),
    customerAddress: new FormControl('Đà Nẵng', Validators.required),
    customerTypeId: new FormControl('1', Validators.required)
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.editCustomerForm);

    if (this.editCustomerForm.invalid) {
      if (this.editCustomerForm.controls.customerCode.value == '') {
        this.editCustomerForm.controls.customerCode.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerName.value == '') {
        this.editCustomerForm.controls.customerName.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerBirthday.value == '') {
        this.editCustomerForm.controls.customerBirthday.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerGender.value == null) {
        this.editCustomerForm.controls.customerGender.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerIdCard.value == '') {
        this.editCustomerForm.controls.customerIdCard.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerPhone.value == '') {
        this.editCustomerForm.controls.customerPhone.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerEmail.value == '') {
        this.editCustomerForm.controls.customerEmail.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerAddress.value == '') {
        this.editCustomerForm.controls.customerAddress.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.editCustomerForm.controls.customerTypeId.value == '') {
        this.editCustomerForm.controls.customerTypeId.setErrors({empty: 'Empty! Please input!'});
      }
    }
  }
}
