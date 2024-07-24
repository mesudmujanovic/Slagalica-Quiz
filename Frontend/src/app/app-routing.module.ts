import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './shared/components/user/user.component';
import { MyNumberComponent } from './shared/components/my-number/my-number.component';
import { AssociationComponent } from './shared/components/association/association.component';

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
