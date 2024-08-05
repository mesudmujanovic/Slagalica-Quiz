import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MyNumberComponent } from './shared/components/my-number/my-number.component';
import { AssociationComponent } from './shared/components/association/association.component';
import { CalculatorComponent } from './shared/components/calculator/calculator.component';
import { SymbolMastermindComponent } from './shared/components/symbol-mastermind/symbol-mastermind.component';
import { MultiplayerComponent } from './shared/components/multiplayer/multiplayer.component';
import { LayoutModule } from './layout/layout.module';
import { AddNumToDivsDirective } from './shared/directives/add-num-to-divs.directive';
import { UserComponent } from './shared/components/user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    MyNumberComponent,
    AssociationComponent,
    CalculatorComponent,
    SymbolMastermindComponent,
    MultiplayerComponent,
    AddNumToDivsDirective,
    UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
