package com.paola.notes.infraestructure.http.note;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paola.notes.domain.note.Note;
import com.paola.notes.service.GetAllNote;

@RestController
public class GetAllNoteController {
	
	private GetAllNote getAllNote;
	
	public GetAllNoteController(GetAllNote getAllNote) {
		this.getAllNote = getAllNote;
	}
	
	@GetMapping("/api/note/get-all-notes")
	public List<Note> handle() {
		return getAllNote.execute();
		
	}

}
