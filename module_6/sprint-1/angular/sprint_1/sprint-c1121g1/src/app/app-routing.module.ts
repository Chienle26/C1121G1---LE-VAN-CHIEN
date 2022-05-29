import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomepageRoutingModule} from './component/homepage/homepage-routing.module';
import {HomepageModule} from './component/homepage/homepage.module';


const routes: Routes = [
  // {path: '', component: HomepageModule}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
