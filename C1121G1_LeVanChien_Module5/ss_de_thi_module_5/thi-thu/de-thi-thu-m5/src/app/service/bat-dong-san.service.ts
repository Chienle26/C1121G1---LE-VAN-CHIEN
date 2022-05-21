import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {BatDongSan} from '../model/bat-dong-san';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BatDongSanService {
  batDongSanApi = 'http://localhost:3000/batdongsan';

  constructor(private http: HttpClient) {
  }

  // getAll(nameSerch: string, priceSearch: string): Observable<Product[]> {
  //   return this.http.get<Product[]>(this.productApi + '?name_like=' + nameSerch + '&price_like=' + priceSearch);
  // }

  getAll(dienTich: string, gia: string, huong: string): Observable<BatDongSan[]> {
    return this.http.get<BatDongSan[]>(this.batDongSanApi + '?dienTich_like=' + dienTich + '&gia_like=' + gia + '&huong_like=' + huong);
  }

  create(batDongSan: BatDongSan): Observable<any> {
    return this.http.post<any>(this.batDongSanApi, batDongSan);
  }
}
