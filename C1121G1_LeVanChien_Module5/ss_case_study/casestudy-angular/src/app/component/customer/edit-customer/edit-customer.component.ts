import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomersService} from '../../../service/customers.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../../model/customer';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  title = 'Edit Customer';
  editCustomerForm: FormGroup;
  id: number;

  constructor(private customersService: CustomersService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.editCustomerForm = new FormGroup({
        id: new FormControl(''),
        customerCode: new FormControl('', [Validators.required, Validators.pattern('^$|^KH-[\\d]{4}$')]),
        customerName: new FormControl('', Validators.required),
        customerBirthday: new FormControl('', Validators.required),
        customerGender: new FormControl('', Validators.required),
        customerIdCard: new FormControl('', [Validators.required, Validators.pattern('^$|^\\d{9}$')]),
        customerPhone: new FormControl('', [Validators.required, Validators.pattern('^$|^(0|\\(84\\)\\+)9[0|1]\\d{7}$')]),
        customerEmail: new FormControl('', [Validators.required, Validators.email]),
        customerAddress: new FormControl('', Validators.required),
        customerTypeId: new FormControl('', Validators.required)
      });
    });
  }

  ngOnInit(): void {
    this.findByCustomer(this.id);
  }

  findByCustomer(id: number) {
    return this.customersService.findCustomerById(id).subscribe((customer) => {
      this.editCustomerForm.patchValue(customer);
    });
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
    } else {
      const customer = this.editCustomerForm.value;
      this.customersService.updateCustomer(this.id, customer).subscribe(() => {
        alert('Chỉnh sửa thành công!');
        this.router.navigateByUrl('/customer/list');
      }, error => {
        console.log(error);
      });
    }
  }
}
