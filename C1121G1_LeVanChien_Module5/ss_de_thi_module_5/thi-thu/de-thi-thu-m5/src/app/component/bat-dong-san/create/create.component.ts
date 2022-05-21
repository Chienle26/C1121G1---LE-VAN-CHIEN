import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DanhMucService} from '../../../service/danh-muc.service';
import {BatDongSanService} from '../../../service/bat-dong-san.service';
import {Router} from '@angular/router';
import {DanhMuc} from '../../../model/danhMuc';
import {BatDongSan} from '../../../model/bat-dong-san';
import {gte2} from '../../../service/gte2';
import {gte} from '../../../service/gte';
import {Product} from '../../../model/product';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  title = 'Thêm mới bài đăng';
  batDongSangForm: FormGroup;
  danhMucs: DanhMuc[] = [];
  batDongSan: BatDongSan;

  constructor(private danhMucService: DanhMucService,
              private batDongSanService: BatDongSanService,
              private router: Router) {
    this.batDongSangForm = new FormGroup({
      id: new FormControl(''),
      danhMuc: new FormControl(''),
      vungMien: new FormControl(''),
      banLa: new FormControl(''),
      dangTin: new FormControl(''),
      tinhTrang: new FormControl('', [Validators.required]),
      diaChi: new FormControl(''),
      dienTich: new FormControl('', [Validators.required, gte]),
      huong: new FormControl(''),
      tuaDe: new FormControl('', [Validators.required]),
      noiDung: new FormControl('', [Validators.required]),
      gia: new FormControl('', [Validators.required, gte2]),
      hinhAnh: new FormControl('')
    });
  }

  get diaChi() {
    return this.batDongSangForm.get('diaChi');
  }

  get dienTich() {
    return this.batDongSangForm.get('dienTich');
  }

  get tuaDe() {
    return this.batDongSangForm.get('tuaDe');
  }

  get noiDung() {
    return this.batDongSangForm.get('noiDung');
  }

  get gia() {
    return this.batDongSangForm.get('gia');
  }

  ngOnInit(): void {
    this.danhMucService.getAll().subscribe((danhMucs) => {
      this.danhMucs = danhMucs;
    });
  }

  onSubmit() {
    if (this.batDongSangForm.invalid) {
      if (this.diaChi.value == '') {
        this.diaChi.setErrors({empty: 'Không đựa để trống. Vui lòng nhập.'});
      }
      if (this.dienTich.value == '') {
        this.dienTich.setErrors({empty: 'Không đựa để trống. Vui lòng nhập.'});
      }
      if (this.tuaDe.value == '') {
        this.tuaDe.setErrors({empty: 'Không đựa để trống. Vui lòng nhập.'});
      }
      if (this.noiDung.value == '') {
        this.noiDung.setErrors({empty: 'Không đựa để trống. Vui lòng nhập.'});
      }
      if (this.gia.value == '') {
        this.gia.setErrors({empty: 'Không đựa để trống. Vui lòng nhập.'});
      }
    } else {
      this.batDongSan = this.batDongSangForm.value;
      this.create(this.batDongSan);
    }
  }

  create(batDongSan: BatDongSan) {
    this.batDongSanService.create(batDongSan).subscribe(() => {
      alert('Tạo mới thành công!');
      this.router.navigateByUrl('/list');
    }, error => {
      alert('Tạo mới thất bại!');
      console.log(error);
    });
  }
}
