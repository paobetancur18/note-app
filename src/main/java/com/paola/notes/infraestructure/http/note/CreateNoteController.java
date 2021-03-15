package com.paola.notes.infraestructure.http.note;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paola.notes.service.CreateNote;

@RestController
public class CreateNoteController {
	
	private CreateNote createNote;
	
	public CreateNoteController(CreateNote createNote) {
		this.createNote = createNote;
	}
	
	@PostMapping("/api/note/create-note")
	public void handle(@RequestBody @Valid Request request) {
		createNote.Execute(request.id, request.tittle, request.description);
	}
	
	public static class Request{
		@NotEmpty
		public String id;
		
		@NotEmpty
		@Size(max=100)
		public String tittle;
		
		@NotEmpty
		@Size(max=400)
		public String description;
	}

}
