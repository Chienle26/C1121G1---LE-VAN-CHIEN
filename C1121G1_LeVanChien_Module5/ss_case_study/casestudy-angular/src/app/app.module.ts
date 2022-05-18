import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { HomeComponent } from './component/home/home.component';
import { ListServiceComponent } from './component/service/list-service/list-service.component';
import { EditServiceComponent } from './component/service/edit-service/edit-service.component';
import { CreateServiceComponent } from './component/service/create-service/create-service.component';
import { ListCustomerComponent } from './component/customer/list-customer/list-customer.component';
import { EditCustomerComponent } from './component/customer/edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './component/customer/create-customer/create-customer.component';
import { ListContractComponent } from './component/contract/list-contract/list-contract.component';
import { CreateContractComponent } from './component/contract/create-contract/create-contract.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { CustomerComponent } from './component/customer/customer.component';
import { ServiceComponent } from './component/service/service.component';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        HomeComponent,
        ListServiceComponent,
        EditServiceComponent,
        CreateServiceComponent,
        ListCustomerComponent,
        EditCustomerComponent,
        CreateCustomerComponent,
        ListContractComponent,
        CreateContractComponent,
        EditCustomerComponent,
        CustomerComponent,
        ServiceComponent
    ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
