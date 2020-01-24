import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BlogEntryComponent } from './blog-entry/blog-entry.component';
import { BlogEntryFormComponent } from './blog-entry-form/blog-entry-form.component';

@NgModule({
  declarations: [
    AppComponent,
    BlogEntryComponent,
    BlogEntryFormComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
