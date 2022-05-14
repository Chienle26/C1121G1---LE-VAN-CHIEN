import { Component, OnInit } from '@angular/core';
import {Facility} from '../model/facility';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {gte} from '../service/gte';

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {
  title = 'Edit Service';
  facility: Facility;
  check = 0;
  createServiceForm: FormGroup;

  constructor() {
    this.createServiceForm = new FormGroup({
      serviceCode: new FormControl('DV-1234', [Validators.required, Validators.pattern('^$|^DV-[\\d]{4}$')]),
      serviceName: new FormControl('Sea Villa', [Validators.required, Validators.pattern('^([a-zA-Z]+[ ]?){1,250}$')]),
      serviceImage: new FormControl('', [Validators.required]),
      serviceArea: new FormControl('200', [Validators.required, gte]),
      serviceCost: new FormControl('2000', [Validators.required, gte]),
      serviceMaxPeople: new FormControl('10', [Validators.required, gte]),
      standardRoom: new FormControl('5*', [Validators.required]),
      descriptionOtherConvenience: new FormControl('Pool, Park,...', [Validators.required]),
      poolArea: new FormControl('50', [Validators.required, gte]),
      numberOfFloors: new FormControl('2', [Validators.required, gte]),
      rentType: new FormControl('1', [Validators.required]),
      serviceType: new FormControl('1', [Validators.required]),
    });
  }

  ngOnInit(): void {
  }


  showFormCreate(event) {
    this.check = event.target.value;
  }

  get serviceCode() {
    return this.createServiceForm.get('serviceCode');
  }

  get serviceName() {
    return this.createServiceForm.get('serviceName');
  }

  get serviceImage() {
    return this.createServiceForm.get('serviceImage');
  }

  get serviceArea() {
    return this.createServiceForm.get('serviceArea');
  }

  get serviceCost() {
    return this.createServiceForm.get('serviceCost');
  }

  get serviceMaxPeople() {
    return this.createServiceForm.get('serviceMaxPeople');
  }

  get standardRoom() {
    return this.createServiceForm.get('standardRoom');
  }

  get descriptionOtherConvenience() {
    return this.createServiceForm.get('descriptionOtherConvenience');
  }

  get poolArea() {
    return this.createServiceForm.get('poolArea');
  }

  get numberOfFloors() {
    return this.createServiceForm.get('numberOfFloors');
  }

  get freeAttachedService() {
    return this.createServiceForm.get('freeAttachedService');
  }

  get rentType() {
    return this.createServiceForm.get('rentType');
  }

  get serviceType() {
    return this.createServiceForm.get('serviceType');
  }


  onSubmit() {
    if (this.createServiceForm.invalid) {
      if (this.serviceCode.value == '') {
        this.serviceCode.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceName.value == '') {
        this.serviceName.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceArea.value == '') {
        this.serviceArea.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceCost.value == '') {
        this.serviceCost.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceMaxPeople.value == '') {
        this.serviceMaxPeople.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.standardRoom.value == '') {
        this.standardRoom.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.descriptionOtherConvenience.value == '') {
        this.descriptionOtherConvenience.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.poolArea.value == '') {
        this.poolArea.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.numberOfFloors.value == '') {
        this.numberOfFloors.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.rentType.value == '') {
        this.rentType.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceType.value == '') {
        this.serviceType.setErrors({empty: 'Empty! Please input!'});
      }
    }
  }
}
