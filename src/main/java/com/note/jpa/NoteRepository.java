package com.note.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.note.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

	
	public List<Note> findNoteByCreatedDate(Date d);
	
	public List<Note> findNoteByTagId(Long id);
	
	public List<Note> findNoteByTagName(String tagName);
	
}
