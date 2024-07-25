import { NgModule, Renderer2 } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NumberStateService } from './core/service/number-state.service';
import { MyNumberComponent } from './shared/components/my-number/my-number.component';
import { UserComponent } from './shared/components/user/user.component';
import { AssociationComponent } from './shared/components/association/association.component';
import { CalculatorComponent } from './shared/components/calculator/calculator.component';
import { SymbolMastermindComponent } from './shared/components/symbol-mastermind/symbol-mastermind.component';
import { AddNumToDivsDirective } from './shared/directives/add-num-to-divs.directive';
import { MultiplayerComponent } from './shared/components/multiplayer/multiplayer.component';
import { LayoutModule } from './layout/layout.module';

@NgModule({
  declarations: [
    AppComponent,
    MyNumberComponent,
    UserComponent,
    AssociationComponent,
    CalculatorComponent,
    SymbolMastermindComponent,
    AddNumToDivsDirective,
    MultiplayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule
  ],
  providers: [
    NumberStateService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
