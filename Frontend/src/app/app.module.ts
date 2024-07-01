import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MyNumberComponent } from './component/my-number/my-number.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserComponent } from './component/user/user.component';
import { AssociationComponent } from './component/association/association.component';
import { SkockoComponent } from './skocko/skocko.component';

@NgModule({
  declarations: [
    AppComponent,
    MyNumberComponent,
    UserComponent,
    AssociationComponent,
    SkockoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
