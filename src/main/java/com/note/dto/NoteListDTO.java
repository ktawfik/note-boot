package com.note.dto;

import java.util.List;

/**
 * Wrapper for the NoteDTO list to exactaly match the rest api results
 * @author ktawfik
 *
 */
public class NoteListDTO {

	private List<NoteDTO> notes;

	public List<NoteDTO> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteDTO> notes) {
		this.notes = notes;
	}
	
}
