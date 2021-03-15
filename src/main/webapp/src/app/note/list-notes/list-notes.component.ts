import { Component, OnInit } from '@angular/core';
import { Note } from '../Note';
import { NoteService } from '../NoteService';

@Component({
  selector: 'app-list-notes',
  templateUrl: './list-notes.component.html',
  styleUrls: ['./list-notes.component.scss']
})
export class ListNotesComponent implements OnInit {
  notes: Note[] = [];

  constructor(private noteService: NoteService) { }

  ngOnInit(): void {
    this.noteService.getlAllNotes().subscribe((notes) => {
      this.notes = notes;

    })
  }

}
