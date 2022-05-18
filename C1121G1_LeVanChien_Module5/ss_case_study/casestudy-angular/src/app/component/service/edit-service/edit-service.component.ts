import {Component, OnInit} from '@angular/core';
import {Facility} from '../../../model/facility';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {gte} from '../../../service/gte';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FacilitiesService} from '../../../service/facilities.service';

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {
  title = 'Edit Service';
  facility: Facility;
  check = 0;
  id: number;
  createServiceForm: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private facilitiesService: FacilitiesService,
              private router: Router) {
    this.createServiceForm = new FormGroup({
      id: new FormControl(''),
      serviceCode: new FormControl('', [Validators.required, Validators.pattern('^$|^DV-[\\d]{4}$')]),
      serviceName: new FormControl('', [Validators.required, Validators.pattern('^([a-zA-Z]+[ ]?){1,250}$')]),
      serviceImage: new FormControl('', [Validators.required]),
      serviceArea: new FormControl('', [Validators.required, gte]),
      serviceCost: new FormControl('', [Validators.required, gte]),
      serviceMaxPeople: new FormControl('', [Validators.required, gte]),
      standardRoom: new FormControl(''),
      descriptionOtherConvenience: new FormControl('', [Validators.required]),
      poolArea: new FormControl('', [gte]),
      numberOfFloors: new FormControl('', [gte]),
      rentType: new FormControl('', [Validators.required]),
      serviceType: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });

    this.facilitiesService.findFacilityById(this.id).subscribe((facility) => {
      console.log(facility);
      this.facility = facility;
      this.check = facility.serviceType;
      this.createServiceForm.patchValue(this.facility);
    }, error => {
      alert('Not find Facility!');
      console.log(error);
    });
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
    } else {
      this.facility = this.createServiceForm.value;
      this.facilitiesService.editFacility(this.facility, this.id).subscribe(() => {
        alert('Chỉnh sửa thành công');
        this.router.navigateByUrl('/facility/list');
      }, error => {
        alert('Chỉnh sửa thất bại');
        console.log(error);
      });
    }
  }
}
