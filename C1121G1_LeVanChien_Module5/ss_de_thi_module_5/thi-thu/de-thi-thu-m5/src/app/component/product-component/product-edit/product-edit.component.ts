import {Component, OnInit} from '@angular/core';
import {Category} from '../../../model/category';
import {Color} from '../../../model/color';
import {Product} from '../../../model/product';
import {FormControl, FormGroup} from '@angular/forms';
import {ColorService} from '../../../service/color.service';
import {CategoryService} from '../../../service/category.service';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  title = 'Edit Product';
  categories: Category[] = [];
  colors: Color[] = [];
  product: Product;
  productForm: FormGroup;
  id: number;

  constructor(private activatedRoute: ActivatedRoute,
              private colorService: ColorService,
              private categoryService: CategoryService,
              private productService: ProductService,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
    this.productForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      price: new FormControl(''),
      quantity: new FormControl(''),
      color: new FormControl(''),
      category: new FormControl(''),
      desc: new FormControl('')
    });
  }

  ngOnInit(): void {
    this.productService.findById(this.id).subscribe((product) => {
      this.productForm.patchValue(product);
      console.log(product);
    });
    this.categoryService.getAllCategory().subscribe((categories) => {
      this.categories = categories;
    });
    this.colorService.getAllColor().subscribe((colors) => {
      this.colors = colors;
    });
    console.log(this.productForm);
  }


  onSubmit() {
    this.product = this.productForm.value;
    this.edit(this.id, this.product);
  }

  edit(id: number, product: Product) {
    this.productService.edit(id, product).subscribe(() => {
      alert('Chỉnh sửa thành công!');
      this.router.navigateByUrl('/product/list');
    }, error => {
      alert('Chỉnh sửa thất bại!');
      console.log(error);
    });
  }

  // Selected

  compareCategory(a: Category, b: Category): boolean {
    return a && b ? a.id === b.id : a === b;
  }

  compareColor(a: Color, b: Color): boolean {
    return a && b ? a.id === b.id : a === b;
  }
}
