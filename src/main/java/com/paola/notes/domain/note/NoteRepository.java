package com.paola.notes.domain.note;

import java.util.List;

public interface NoteRepository {

	public void store(Note note);
	public List <Note> findAll();
	public Note findById(String id);
	public void deleteById(String id);

}
