import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {gte} from '../service/gte';
import {EmployeesService} from '../service/employees.service';
import {CustomersService} from '../service/customers.service';
import {FacilitiesService} from '../service/facilities.service';
import {Facility} from '../model/facility';
import {Customer} from '../model/customer';
import {Employee} from '../model/employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {
  title = 'Create Contract';
  contractCreateForm: FormGroup;
  employees: Employee[] = [];
  customers: Customer[] = [];
  facilities: Facility[] = [];

  constructor(private employeeService: EmployeesService,
              private customerService: CustomersService,
              private facilityService: FacilitiesService,
              private router: Router) {
    this.employees = this.employeeService.getEmployees();
    this.customers = this.customerService.getCustomers();
    this.facilities = this.facilityService.getFacilities();
  }

  ngOnInit(): void {
    this.contractCreateForm = new FormGroup({
      contractStartDate: new FormControl('', [Validators.required]),
      contractEndDate: new FormControl('', [Validators.required]),
      contractDeposit: new FormControl('', [Validators.required, gte]),
      contractTotalMoney: new FormControl('', [Validators.required, gte]),
      employee: new FormControl('', [Validators.required]),
      customer: new FormControl('', [Validators.required]),
      services: new FormControl('', [Validators.required]),
    });
  }

  get contractStartDate() {
    return this.contractCreateForm.get('contractStartDate');
  }

  get contractEndDate() {
    return this.contractCreateForm.get('contractEndDate');
  }

  get contractDeposit() {
    return this.contractCreateForm.get('contractDeposit');
  }

  get contractTotalMoney() {
    return this.contractCreateForm.get('contractTotalMoney');
  }

  get employee() {
    return this.contractCreateForm.get('employee');
  }

  get customer() {
    return this.contractCreateForm.get('customer');
  }

  get services() {
    return this.contractCreateForm.get('services');
  }

  onSubmit() {
    if (this.contractCreateForm.invalid) {
      if (this.contractStartDate.value == '') {
        this.contractStartDate.setErrors({empty: 'Empty! Please choose!'});
      }
      if (this.contractEndDate.value == '') {
        this.contractEndDate.setErrors({empty: 'Empty! Please choose!'});
      }
      if (this.contractDeposit.value == '') {
        this.contractDeposit.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.contractTotalMoney.value == '') {
        this.contractTotalMoney.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.employee.value == '') {
        this.employee.setErrors({empty: 'Empty! Please choose!'});
      }
      if (this.customer.value == '') {
        this.customer.setErrors({empty: 'Empty! Please choose!'});
      }
      if (this.services.value == '') {
        this.services.setErrors({empty: 'Empty! Please choose!'});
      }

      if (this.contractStartDate.value != '' && this.contractEndDate.value != '') {
        const contractStartDateParse = new Date(this.contractStartDate.value);
        const contractEndDateParse = new Date(this.contractEndDate.value);
        // const currentDate = new Date(Date.now());
        if (contractStartDateParse > contractEndDateParse) {
          this.contractStartDate.setErrors({dateErrors: 'Start date must be before end date! Please choose again!'});
          this.contractEndDate.setErrors({dateErrors: 'End date must be after start date! Please choose again!'});
        }

        // if (contractEndDateParse < currentDate || contractStartDateParse < currentDate) {
        //   this.contractStartDate.setErrors({dateErrors: 'Start date must be before current date! Please choose again!'});
        //   this.contractEndDate.setErrors({dateErrors: 'End date must be after current date! Please choose again!'});
        // }
      }

      // this.router.navigate(['/contract/list']);
    }
  }
}
