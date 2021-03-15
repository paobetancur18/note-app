package com.paola.notes.domain.note.exception;

public class NoteNotFound extends RuntimeException {
	
	public NoteNotFound(String id) {
		super("Note with "+id+" not found");
	}

}
