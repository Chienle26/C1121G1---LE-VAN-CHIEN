import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ListCustomerComponent} from './component/customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './component/customer/create-customer/create-customer.component';
import {EditCustomerComponent} from './component/customer/edit-customer/edit-customer.component';
import {HomeComponent} from './component/home/home.component';
import {ListServiceComponent} from './component/service/list-service/list-service.component';
import {CreateServiceComponent} from './component/service/create-service/create-service.component';
import {EditServiceComponent} from './component/service/edit-service/edit-service.component';
import {ListContractComponent} from './component/contract/list-contract/list-contract.component';
import {CreateContractComponent} from './component/contract/create-contract/create-contract.component';
import {ContractRoutingModule} from './component/contract/contract-routing.module';
import {CustomerModule} from './component/customer/customer.module';
import {ServiceModule} from './component/service/service.module';

const routes: Routes = [
  {path: '', component: HomeComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    ContractRoutingModule,
    CustomerModule,
    ServiceModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
