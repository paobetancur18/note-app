package com.paola.notes.infraestructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.paola.notes.domain.note.Note;
import com.paola.notes.domain.note.NoteRepository;

//@Repository
public class MapFileNoteRepository implements NoteRepository {
	
	private Map<String, Note> database;
	private FileStore fileStore;
	
	public  MapFileNoteRepository() {
		database = new HashMap<>();
		fileStore = new FileStore("note");
	}
	
	@PostConstruct
	public void init() {
		List<Note> notes = fileStore.getAll();
		for(Note note: notes) {
			database.put(note.getId(), note);
		}
		
	}

	@Override
	public void store(Note note) {
		database.put(note.getId(), note);
		fileStore.put(note.getId(), note);
		
	}

	@Override
	public List<Note> findAll() {
		List<Note> list = new ArrayList<Note>();
		for (Map.Entry<String, Note> entry : database.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	@Override
	public Note findById(String id) {
		// TODO Auto-generated method stub
		return database.get(id);
	}

	@Override
	public void deleteById(String id) {
		database.remove(id);
		fileStore.remove(id);
		
	}

}
