import { Component, OnInit } from '@angular/core';
import { Note } from './note/Note';
import { NoteService } from './note/NoteService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent{
  tittle = 'Note App';

  constructor(){
  }
}



