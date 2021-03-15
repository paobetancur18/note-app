package com.paola.notes.service;

import org.springframework.stereotype.Service;

import com.paola.notes.domain.note.Note;
import com.paola.notes.domain.note.NoteRepository;
import com.paola.notes.domain.note.exception.NoteNotFound;

@Service
public class DeleteById {
	private NoteRepository noteRepository;

	public DeleteById(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public void execute(String id) {
		Note note = noteRepository.findById(id);
		
		if (note == null) {
			throw new NoteNotFound(id);
		}
		noteRepository.deleteById(id);
				
	}
}
