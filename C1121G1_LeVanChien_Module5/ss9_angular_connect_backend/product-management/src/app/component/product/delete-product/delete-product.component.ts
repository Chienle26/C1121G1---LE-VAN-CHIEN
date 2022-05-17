import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.css']
})
export class DeleteProductComponent implements OnInit {
  productForm: FormGroup;
  id: number;
  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramap: ParamMap) => {
        this.id = +paramap.get('id');
        const product = this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
  }

  getProduct(id: number){
    return this.productService.findProductById(id).subscribe((product) => {
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description)
      });
    });
  }

  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe(() => {
      alert('Xóa thành công!');
      this.router.navigate(['/product/list']);
    }, error => {
      console.log(error);
    });
  }
}
