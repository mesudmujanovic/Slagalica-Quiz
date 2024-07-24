import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SooterComponent } from './sooter/sooter.component';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent
    ],
  imports: [
    CommonModule
  ],
  export: [
  HeaderComponent,
  FooterComponent
  ]
})
export class LayoutModule { }
