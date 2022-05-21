import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Category} from '../model/category';
import {DanhMuc} from '../model/danhMuc';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DanhMucService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<DanhMuc[]> {
    return this.http.get<DanhMuc[]>('http://localhost:3000/danhmuc');
  }
}
