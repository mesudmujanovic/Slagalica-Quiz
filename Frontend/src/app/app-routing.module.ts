import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyNumberComponent } from './component/my-number/my-number.component';
import { UserComponent } from './component/user/user.component';
import { AssociationComponent } from './component/association/association.component';

const routes: Routes = [
  {path:'', component: MyNumberComponent },
  {path:'user', component: UserComponent},
  {path:'association', component: AssociationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
