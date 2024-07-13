import { NgModule, Renderer2 } from '@angular/core';
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
import { NumberStateService } from './core/service/number-state.service';
import { NumSpinDirective } from './num-spin.directive';
import { AddNumToDivsDirective } from './core/directive/add-num-to-divs.directive';

@NgModule({
  declarations: [
    AppComponent,
    MyNumberComponent,
    UserComponent,
    AssociationComponent,
    CalculatorComponent,
    SymbolMastermindComponent,
    NumSpinDirective,
    AddNumToDivsDirective,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    NumberStateService
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
