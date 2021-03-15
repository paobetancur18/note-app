package com.paola.notes.infraestructure.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paola.notes.domain.note.Note;

public class FileStore {
	
	private String tableName;
	private String filePath;
	private ObjectMapper objectMapper;
	
	public FileStore(String tableName) {
		this.tableName = tableName;
		this.filePath = "." +  File.separator  + "data" +   File.separator  + tableName;
		this.objectMapper = new ObjectMapper();
	}
	
	public void put(String key, Note note) {
		try {
			//data/note/1.txt
			File file = new File(filePath +  File.separator + key);
			//data/note
			file.getParentFile().mkdirs();			
			objectMapper.writeValue(file, note);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Note> getAll(){
		List<Note> list = new ArrayList<>();
		// data/note
		File folder = new File(filePath);
		
		if(!folder.exists()) {
			return list;
		}
		
		
		for(File file: folder.listFiles()) {

			try {
				Note note =null;				
				note = objectMapper.readValue(file, Note.class);
				list.add(note);				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public void remove(String key) {
		File file = new File(filePath +  File.separator + key);
		file.delete();
	}

}
