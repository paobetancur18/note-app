package com.paola.notes.service;

import org.springframework.stereotype.Service;

import com.paola.notes.domain.note.Note;
import com.paola.notes.domain.note.NoteRepository;
import com.paola.notes.domain.note.exception.NoteNotFound;

@Service
public class UpdateNote {
	
	private NoteRepository noteRepository;

	public UpdateNote(NoteRepository noteRepository) {
		this.noteRepository  = noteRepository;
	}
	
	public void execute(String id, String tittle, String description) {
		Note note = noteRepository.findById(id);
		
		if(note == null) {
			throw new NoteNotFound(id);
		}
		
		note.setTittle(tittle);
		note.setDescription(description);
		noteRepository.store(note);
		
	}
}
