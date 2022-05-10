import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ListServiceComponent } from './list-service/list-service.component';
import { EditServiceComponent } from './edit-service/edit-service.component';
import { CreateServiceComponent } from './create-service/create-service.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { ListContractComponent } from './list-contract/list-contract.component';
import { CreateContractComponent } from './create-contract/create-contract.component';

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
    CreateContractComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
