import {Component, OnInit} from '@angular/core';
import {ColorService} from '../../../service/color.service';
import {CategoryService} from '../../../service/category.service';
import {Router} from '@angular/router';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {Category} from '../../../model/category';
import {Color} from '../../../model/color';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {gte} from '../../../service/gte';
import {gte2} from '../../../service/gte2';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  title = 'Create Product';
  categories: Category[] = [];
  colors: Color[] = [];
  product: Product;
  productForm: FormGroup;

  constructor(private colorService: ColorService,
              private categoryService: CategoryService,
              private productService: ProductService,
              private router: Router) {
    this.productForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required, gte2]),
      quantity: new FormControl('', [Validators.required, gte]),
      color: new FormControl(''),
      category: new FormControl(''),
      desc: new FormControl('')
    });
  }

  ngOnInit(): void {
    this.categoryService.getAllCategory().subscribe((categories) => {
      this.categories = categories;
      this.productForm.controls.category.setValue(this.categories[0]);
    });
    this.colorService.getAllColor().subscribe((colors) => {
      this.colors = colors;
      this.productForm.controls.color.setValue(this.colors[1]);
    });
  }

  get name() {
    return this.productForm.get('name');
  }

  get price() {
    return this.productForm.get('price');
  }

  get quantity() {
    return this.productForm.get('quantity');
  }

  get color() {
    return this.productForm.get('color');
  }

  get category() {
    return this.productForm.get('category');
  }

  get desc() {
    return this.productForm.get('desc');
  }

  onSubmit() {
    if (this.productForm.invalid) {
      if (this.name.value == '') {
        this.name.setErrors({empty: 'Empty! Please choose.'});
      }
      if (this.price.value == '') {
        this.price.setErrors({empty: 'Empty! Please choose.'});
      }
      if (this.quantity.value == '') {
        this.quantity.setErrors({empty: 'Empty! Please choose.'});
      }
    } else {
      this.product = this.productForm.value;
      this.create(this.product);
    }

  }

  create(product: Product) {
    this.productService.create(product).subscribe(() => {
      alert('Tạo mới thành công!');
      this.router.navigateByUrl('product/list');
    }, error => {
      alert('Tạo mới thất bại!');
      console.log(error);
    });
  }
}
