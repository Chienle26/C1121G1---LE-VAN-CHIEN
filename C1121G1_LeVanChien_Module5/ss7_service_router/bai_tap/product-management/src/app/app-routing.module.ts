import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListProductComponent} from "./component/list-product/list-product.component";
import {CreateProductComponent} from "./component/create-product/create-product.component";
import {EditProductComponent} from "./component/edit-product/edit-product.component";
import {DeleteProductComponent} from "./component/delete-product/delete-product.component";


const routes: Routes = [
  {path: 'product/list', component: ListProductComponent},
  {path: 'product/create', component: CreateProductComponent},
  {path: 'product/edit/:id', component: EditProductComponent},
  {path: 'product/delete/:id', component: DeleteProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
