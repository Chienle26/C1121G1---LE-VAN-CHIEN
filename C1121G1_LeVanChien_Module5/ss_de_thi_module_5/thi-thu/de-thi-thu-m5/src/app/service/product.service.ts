import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productApi = 'http://localhost:3000/product';

  constructor(private http: HttpClient) {
  }

  // Search

  getAllProduct(nameSerch: string, priceSearch: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.productApi + '?name_like=' + nameSerch + '&price_like=' + priceSearch);
  }

  // getAllProduct(nameSerch: string): Observable<Product[]> {
  //   return this.http.get<Product[]>(this.productApi + '?q=' + nameSerch);
  // }

  create(product: Product): Observable<any> {
    return this.http.post<any>(this.productApi, product);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.productApi + '/' + id);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(this.productApi + '/' + id);
  }

  edit(id: number, product: Product): Observable<any> {
    return this.http.put<any>(this.productApi + '/' + id, product);
  }
}
