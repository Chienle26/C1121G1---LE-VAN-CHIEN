import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  title = 'List Product';
  products: Product[] = [];
  check = false;
  deleteProduct: Product;
  id: number;
  p = 1;
  nameSearch = '';
  priceSearch = '';

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.getAllProduct(this.nameSearch, this.priceSearch).subscribe((products) => {
      this.products = products;
    }, error => {
      console.log('not find list product');
      console.log(error);
    });
  }

  onOpenEditModal(productChooseDelete: Product) {
    this.deleteProduct = productChooseDelete;
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#deleteModal');
    container.appendChild(button);
    this.check = true;
    button.click();
  }

  delete(event) {
    this.productService.delete(this.deleteProduct.id).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, error => {
      console.log(error);
    });
  }

  // search() {
  //   if (this.nameSearch === ''){
  //     this.ngOnInit();
  //   } else {
  //     this.products = this.products.filter(res => {
  //       return res.name.toLocaleLowerCase().match(this.nameSearch.toLocaleLowerCase());
  //     });
  //   }
  // }

  // Xóa nhiều trường
  deleteMulti(event) {
    const checkboxes = document.querySelectorAll('input[type=\'checkbox\']:checked');
    let arrId: Array<number> = [];
    let temp;
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < checkboxes.length; i++) {
      temp = checkboxes[i];
      arrId.push(temp.value);
    }

    for (let i = 0; i < arrId.length; i++) {
      this.productService.delete(arrId[i]).subscribe(() => {

      }, error => {
        console.log(error);
      }, () => {
        this.getAllProduct();
      });
    }
    event.click();
  }
}
