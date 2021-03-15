package com.paola.notes.service;

import org.springframework.stereotype.Service;

import com.paola.notes.domain.note.Note;
import com.paola.notes.domain.note.NoteRepository;

@Service
public class CreateNote {
	private NoteRepository noteRepository;
	
	public CreateNote(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	public void Execute(String id, String tittle, String description) {
		Note note = new Note(id, tittle, description);
		
		noteRepository.store(note);
	}
}
