import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AnnotationModule} from "@groupdocs.examples.angular/annotation";

import { TranslateModule } from '@ngx-translate/core';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, AnnotationModule, TranslateModule.forRoot()],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
