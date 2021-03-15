import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ErrorResponse } from '../ErrorResponse';
import { Note } from '../Note';
import { NoteService } from '../NoteService';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-create-notes',
  templateUrl: './create-notes.component.html',
  styleUrls: ['./create-notes.component.scss']
})
export class CreateNotesComponent{
  form: FormGroup;
  error: ErrorResponse | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private noteService: NoteService) {
    this.form = this.formBuilder.group({
      tittle: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  onSubmit(): void {
    const note: Note={
      id: uuidv4(),
      tittle: this.form.value.tittle,
      description: this.form.value.description
    }
    this.noteService.save(note).subscribe(()=>{
      this.router.navigate(['/note/list']);
    },(data)=>{
      this.error = data.error;
    });
  }
}
