import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [];

  productApi = 'http://localhost:3000/product';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Product[]>{
    return this.http.get<Product[]>(this.productApi);
  }

  saveProduct(product: Product): Observable<Product>{
    return this.http.post<Product>(this.productApi, product);
  }

  findProductById(id: number): Observable<Product>{
    return this.http.get<Product>(this.productApi + '/' + id);
  }

  updateProduct(id: number, productNew: Product): Observable<Product>{
    return this.http.put<Product>(this.productApi + '/' + id, productNew);
  }

  deleteProduct(id: number){
    return this.http.delete<Product>(this.productApi + '/' + id);
  }
}
