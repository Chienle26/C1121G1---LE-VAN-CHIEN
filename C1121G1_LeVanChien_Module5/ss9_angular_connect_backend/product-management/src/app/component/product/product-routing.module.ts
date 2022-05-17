import { NgModule } from '@angular/core';
import {Routes, RouterModule, RouterLink} from '@angular/router';
import {ListProductComponent} from './list-product/list-product.component';
import {CreateProductComponent} from './create-product/create-product.component';
import {EditProductComponent} from './edit-product/edit-product.component';
import {DeleteProductComponent} from './delete-product/delete-product.component';


const routes: Routes = [
  {path: 'product/list', component: ListProductComponent},
  {path: 'product/create', component: CreateProductComponent},
  {path: 'product/edit/:id', component: EditProductComponent},
  {path: 'product/delete/:id', component: DeleteProductComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
