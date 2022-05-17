import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListServiceComponent} from './list-service/list-service.component';
import {CreateServiceComponent} from './create-service/create-service.component';
import {EditServiceComponent} from './edit-service/edit-service.component';


const routes: Routes = [
  {path: 'facility/list', component: ListServiceComponent},
  {path: 'facility/create', component: CreateServiceComponent},
  {path: 'facility/edit/:id', component: EditServiceComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceRoutingModule { }
