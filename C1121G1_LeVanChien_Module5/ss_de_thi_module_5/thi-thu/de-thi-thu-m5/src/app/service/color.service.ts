import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Color} from '../model/color';

@Injectable({
  providedIn: 'root'
})
export class ColorService {

  constructor(private http: HttpClient) {
  }

  getAllColor(): Observable<Color[]> {
    return this.http.get<Color[]>('http://localhost:3000/color');
  }
}
