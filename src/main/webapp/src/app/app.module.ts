import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoteService } from './note/NoteService';
import { ListNotesComponent } from './note/list-notes/list-notes.component';
import { CreateNotesComponent } from './note/create-notes/create-notes.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ListNotesComponent,
    CreateNotesComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule 
  ],
  providers: [NoteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
