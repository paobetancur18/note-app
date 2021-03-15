package com.paola.notes.infraestructure.http.note;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.paola.notes.service.DeleteById;

@RestController
public class DeleteByIdController {
	
	private DeleteById deleteById;
	
	public DeleteByIdController (DeleteById deleteById) {
		this.deleteById = deleteById;
	}
	
	@DeleteMapping ("/api/note/delete-by-id/{id}")
	public void handle(@PathVariable("id") String id) {
		deleteById.execute(id);
	}

}
