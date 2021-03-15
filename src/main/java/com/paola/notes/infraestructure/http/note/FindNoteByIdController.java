package com.paola.notes.infraestructure.http.note;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.paola.notes.domain.note.Note;
import com.paola.notes.service.FindAllById;

@RestController
public class FindNoteByIdController {
	
	private FindAllById findAllById;
	
	public FindNoteByIdController(FindAllById findAllById) {
		this.findAllById = findAllById;
	}
	
	@GetMapping("/api/note/find-all-by-id/{id}")
	public Note handle(@PathVariable("id") String id) {
		return findAllById.execute(id);
		
	}

}
