import { Injectable } from '@angular/core';
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] =[{
    id: 1,
    name: 'Iphone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor() { }

  getAll(){
    return this.products;
  }

  saveProduct(product){
    this.products.push(product);
  }

  findProductById(id: number){
    // if (id != null){
    //   for (let product of this.products){
    //     if (product.id === id){
    //       return product;
    //     }
    //   }
    // }
    return this.products.find(product => product.id === id)
  }

  updateProduct(id: number, productNew: Product){
    for (let i =0; i< this.products.length; i++){
          if (this.products[i].id === id){
              this.products[i] = productNew;
          }
        }
  }

  deleteProduct(id: number){
    this.products = this.products.filter(product => {
      return product.id != id;
    })
  }
}
