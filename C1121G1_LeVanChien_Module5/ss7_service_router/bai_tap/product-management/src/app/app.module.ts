import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateProductComponent } from './component/create-product/create-product.component';
import { ListProductComponent } from './component/list-product/list-product.component';
import {ReactiveFormsModule} from "@angular/forms";
import { EditProductComponent } from './component/edit-product/edit-product.component';
import { DeleteProductComponent } from './component/delete-product/delete-product.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateProductComponent,
    ListProductComponent,
    EditProductComponent,
    DeleteProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
