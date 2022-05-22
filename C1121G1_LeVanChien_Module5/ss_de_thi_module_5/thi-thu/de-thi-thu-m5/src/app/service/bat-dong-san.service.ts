import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {BatDongSan} from '../model/bat-dong-san';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BatDongSanService {
  // batDongSanApi = 'http://localhost:3000/batdongsan';
  batDongSanApi = 'http://localhost:8080/bat-dong-san';

  constructor(private http: HttpClient) {
  }

  // getAll(nameSerch: string, priceSearch: string): Observable<Product[]> {
  //   return this.http.get<Product[]>(this.productApi + '?name_like=' + nameSerch + '&price_like=' + priceSearch);
  // }

  // getAll(dienTich: string, gia: string, huong: string): Observable<BatDongSan[]> {
  //   return this.http.get<BatDongSan[]>(this.batDongSanApi + '?dienTich_like=' + dienTich + '&gia_like=' + gia + '&huong_like=' + huong);
  // }

  getAll(): Observable<any> {
    return this.http.get<any>(this.batDongSanApi + '/list');
  }

  create(batDongSan: BatDongSan): Observable<any> {
    return this.http.post<any>(this.batDongSanApi + '/create', batDongSan);
  }
}
