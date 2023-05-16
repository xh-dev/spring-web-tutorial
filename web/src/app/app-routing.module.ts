import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListComponent} from "./page/list/list.component";
import {AddComponent} from "./page/add/add.component";

const routes: Routes = [
  {path: "list", component: ListComponent},
  {path: "add", component: AddComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
