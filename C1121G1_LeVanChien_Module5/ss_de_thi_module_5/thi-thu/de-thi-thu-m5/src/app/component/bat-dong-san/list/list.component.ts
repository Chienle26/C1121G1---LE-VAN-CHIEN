import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {BatDongSanService} from '../../../service/bat-dong-san.service';
import {BatDongSan} from '../../../model/bat-dong-san';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  title = 'Danh Sách Bài Đăng';
  batDongSans: BatDongSan[] = [];
  dienTich = '';
  gia = '';
  huong = '';

  constructor(private batDongSanService: BatDongSanService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  // getAll() {
  //   this.batDongSanService.getAll(this.dienTich, this.gia, this.huong).subscribe((batDongSans) => {
  //     this.batDongSans = batDongSans;
  //   }, error => {
  //     console.log('not find list product');
  //     console.log(error);
  //   });
  // }

  getAll() {
    this.batDongSanService.getAll().subscribe((batDongSans) => {
      this.batDongSans = batDongSans;
    }, error => {
      console.log('not find list product');
      console.log(error);
    });
  }

}
