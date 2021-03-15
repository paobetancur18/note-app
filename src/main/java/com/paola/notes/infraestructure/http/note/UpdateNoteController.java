package com.paola.notes.infraestructure.http.note;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paola.notes.service.UpdateNote;

@RestController
public class UpdateNoteController {
	private UpdateNote updateNote;
	
	public UpdateNoteController(UpdateNote updateNote) {
		this.updateNote = updateNote;
	}
    
	@PutMapping("/api/note/update-note/{id}")
	public void handle(@PathVariable ("id") String id, @RequestBody @Valid Request request) {
		updateNote.execute(id, request.tittle, request.description);
	}
	
	public static class Request {
		@NotEmpty
		@Size(max=100)
		public String tittle;
		
		@NotEmpty
		@Size(max=400)
		public String description;
	}
}
