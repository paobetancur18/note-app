package com.paola.notes.service;

import org.springframework.stereotype.Service;

import com.paola.notes.domain.note.Note;
import com.paola.notes.domain.note.NoteRepository;

@Service
public class FindAllById {
	private NoteRepository noteRepository;
	
	public FindAllById(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;	
	}

	public Note execute(String id) {
		return noteRepository.findById(id);
		
	}
}
