import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Facility} from '../../../model/facility';
import {gte} from '../../../service/gte';
import {FacilitiesService} from '../../../service/facilities.service';
import {Router} from '@angular/router';
import {RentTypeService} from '../../../service/rent-type.service';
import {RentType} from '../../../model/rent-type';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {
  title = 'Create Service';
  facility: Facility;
  createServiceForm: FormGroup;
  check = 0;
  img = 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg';

  constructor(private facilitiesService: FacilitiesService,
              private router: Router,
              private rentTypeService: RentTypeService) {
    this.createServiceForm = new FormGroup({
      id: new FormControl(''),
      serviceCode: new FormControl('', [Validators.required, Validators.pattern('^$|^DV-[\\d]{4}$')]),
      serviceName: new FormControl('', [Validators.required, Validators.pattern('^([a-zA-Z]+[ ]?){1,250}$')]),
      serviceImage: new FormControl(this.img),
      serviceArea: new FormControl('', [Validators.required, gte]),
      serviceCost: new FormControl('', [Validators.required, gte]),
      serviceMaxPeople: new FormControl('', [Validators.required, gte]),
      standardRoom: new FormControl(''),
      descriptionOtherConvenience: new FormControl('', [Validators.required]),
      poolArea: new FormControl('', [gte]),
      numberOfFloors: new FormControl('', [gte]),
      rentType: new FormControl('1', [Validators.required]),
      serviceType: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
  }


  showFormCreate(event) {
    this.check = event.target.value;
    this.createServiceForm.controls.serviceType.setValue(this.check);
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

  // // Ẩn validate
  // hiddenPoolArea() {
  //   this.createServiceForm.get('poolArea').disable();
  // }
  //
  // // Hiện validate
  // appearPoolArea() {
  //   this.createServiceForm.get('poolArea').enable();
  // }

  onSubmit() {
    console.log(this.createServiceForm);

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
      alert('Lỗi validate.');
    } else {
      this.facility = this.createServiceForm.value;
      this.createFacility(this.facility);
    }
  }

  createFacility(facility: Facility) {
    this.facilitiesService.createFacility(facility).subscribe(() => {
      alert('Thêm mới thành công!');
      this.router.navigateByUrl('/facility/list');
    }, error => {
      alert('Thêm mới thất bại!');
      console.log(error);
    });
  }
}


