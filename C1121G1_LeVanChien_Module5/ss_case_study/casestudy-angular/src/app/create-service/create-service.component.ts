import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Facility} from '../model/facility';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {
  facility: Facility;
  createServiceForm: FormGroup;
  constructor() {
    this.createServiceForm = new FormGroup ({
      serviceCode: new FormControl('', [Validators.required, Validators.pattern('^$|^DV-[\\d]{4}$')]),
      serviceName: new FormControl('', [Validators.required]),
      serviceImage: new FormControl('', [Validators.required]),
      serviceArea: new FormControl('', [Validators.required]),
      serviceCost: new FormControl('', [Validators.required]),
      serviceMaxPeople: new FormControl('', [Validators.required]),
      standardRoom: new FormControl('', [Validators.required]),
      descriptionOtherConvenience: new FormControl('', [Validators.required]),
      poolArea: new FormControl('', [Validators.required]),
      numberOfFloors: new FormControl('', [Validators.required]),
      rentType: new FormControl('', [Validators.required]),
      serviceType: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
  }
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
      // if (this.standardRoom.value == '') {
      //   this.standardRoom.setErrors({empty: 'Empty! Please input!'})
      // }
      // if (this.descriptionOtherConvenience.value == '') {
      //   this.descriptionOtherConvenience.setErrors({empty: 'Empty! Please input!'})
      // }
      if (this.poolArea.value == '') {
        this.poolArea.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.numberOfFloors.value == '') {
        this.numberOfFloors.setErrors({empty: 'Empty! Please input!'});
      }

      // if (this.rentType.value == '') {
      //   this.rentType.setErrors({empty: 'Empty! Please input!'})
      // }
      // if (this.serviceType.value == '') {
      //   this.serviceType.setErrors({empty: 'Empty! Please input!'})
      // }
  }
}
