import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MyNumberComponent } from './shared/component/my-number/my-number.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserComponent } from './shared/component/user/user.component';
import { AssociationComponent } from './shared/component/association/association.component';
import { CalculatorComponent } from './shared/component/calculator/calculator.component';
import { SymbolMastermindComponent } from './shared/component/symbol-mastermind/symbol-mastermind.component';

@NgModule({
  declarations: [
    AppComponent,
    MyNumberComponent,
    UserComponent,
    AssociationComponent,
    CalculatorComponent,
    SymbolMastermindComponent,
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
