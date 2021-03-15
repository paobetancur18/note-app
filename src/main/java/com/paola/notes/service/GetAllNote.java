package com.paola.notes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paola.notes.domain.note.Note;
import com.paola.notes.domain.note.NoteRepository;

@Service
public class GetAllNote {
	
	private NoteRepository noteRepository;
	
	public GetAllNote(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public List<Note> execute(){
		return noteRepository.findAll();
	}

}
