import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyNumberComponent } from './shared/component/my-number/my-number.component';
import { UserComponent } from './shared/component/user/user.component';
import { AssociationComponent } from './shared/component/association/association.component';

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
