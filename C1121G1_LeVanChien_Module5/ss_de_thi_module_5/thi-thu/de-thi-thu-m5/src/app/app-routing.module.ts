import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {ProductComponent} from './component/product-component/product/product.component';
import {ProductCreateComponent} from './component/product-component/product-create/product-create.component';
import {ProductEditComponent} from './component/product-component/product-edit/product-edit.component';
import {ListComponent} from './component/bat-dong-san/list/list.component';
import {CreateComponent} from './component/bat-dong-san/create/create.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'product/list', component: ProductComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product/edit/:id', component: ProductEditComponent},
  {path: 'list', component: ListComponent},
  {path: 'create', component: CreateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
