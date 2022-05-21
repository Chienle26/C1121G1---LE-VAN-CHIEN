import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import {RouterModule} from "@angular/router";
import { ProductComponent } from './component/product-component/product/product.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductCreateComponent } from './component/product-component/product-create/product-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ProductEditComponent } from './component/product-component/product-edit/product-edit.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { ListComponent } from './component/bat-dong-san/list/list.component';
import { CreateComponent } from './component/bat-dong-san/create/create.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    ProductComponent,
    ProductCreateComponent,
    ProductEditComponent,
    ListComponent,
    CreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
