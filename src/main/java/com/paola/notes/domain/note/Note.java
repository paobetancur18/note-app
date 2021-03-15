package com.paola.notes.domain.note;

public class Note {
	private String id;
	private String tittle;
	private String description;
	
	public Note(String id, String tittle, String description) {
		this.id = id;
		this.tittle = tittle;
		this.description = description;
	}

	public Note() {
		
	}
	
	public String getId() {
		return id;
	}

	public String getTittle() {
		return tittle;
	}

	public String getDescription() {
		return description;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
