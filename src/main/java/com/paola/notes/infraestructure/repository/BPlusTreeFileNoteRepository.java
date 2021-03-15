package com.paola.notes.infraestructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.paola.notes.domain.note.Note;
import com.paola.notes.domain.note.NoteRepository;

@Repository
public class BPlusTreeFileNoteRepository implements NoteRepository {
	
	private BPlusTree<String, Note> database;
	private FileStore fileStore;
	
	public  BPlusTreeFileNoteRepository() {
		database = new BPlusTree();
		fileStore = new FileStore("note");
	}
	
	@PostConstruct
	public void init() {
		List<Note> notes = fileStore.getAll();
		for(Note note: notes) {
			database.insert(note.getId(), note);
		}
		
	}

	@Override
	public void store(Note note) {
		database.insert(note.getId(), note);
		fileStore.put(note.getId(), note);
		
	}

	@Override
	public List<Note> findAll() {
		return database.getValues();
	}

	@Override
	public Note findById(String id) {
		return database.search(id);
	}

	@Override
	public void deleteById(String id) {
		database.delete(id);
		fileStore.remove(id);
		
	}

}
