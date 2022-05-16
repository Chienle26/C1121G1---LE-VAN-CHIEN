import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {HomeComponent} from './home/home.component';
import {ListServiceComponent} from './list-service/list-service.component';
import {CreateServiceComponent} from './create-service/create-service.component';
import {EditServiceComponent} from './edit-service/edit-service.component';
import {ListContractComponent} from './list-contract/list-contract.component';
import {CreateContractComponent} from './create-contract/create-contract.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer/list', component: ListCustomerComponent},
  {path: 'customer/create', component: CreateCustomerComponent},
  {path: 'customer/edit/:id', component: EditCustomerComponent},
  {path: 'facility/list', component: ListServiceComponent},
  {path: 'facility/create', component: CreateServiceComponent},
  {path: 'facility/edit/:id', component: EditServiceComponent},
  {path: 'contract/list', component: ListContractComponent},
  {path: 'contract/create', component: CreateContractComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
