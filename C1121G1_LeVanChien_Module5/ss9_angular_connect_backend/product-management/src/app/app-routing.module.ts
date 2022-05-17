import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListProductComponent} from './component/product/list-product/list-product.component';
import {CreateProductComponent} from './component/product/create-product/create-product.component';
import {EditProductComponent} from './component/product/edit-product/edit-product.component';
import {DeleteProductComponent} from './component/product/delete-product/delete-product.component';


const routes: Routes = [
  {
    path: 'product',
    loadChildren: () => import('./component/product/product.module').then(module => module.ProductModule)
  },
  {
    path: 'category',
    loadChildren: () => import('./component//category/category.module').then(module => module.CategoryModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
