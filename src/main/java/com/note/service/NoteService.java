package com.note.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.note.dto.NoteDTO;
import com.note.dto.NoteListDTO;
import com.note.jpa.NoteRepository;
import com.note.model.Note;
import com.note.util.Constants;
import com.note.util.NoteMapper;

/**
 * @author ktawfik
 *
 */
@Service
public class NoteService {

	
	@Autowired
	private NoteRepository noteRepo;
	
	/**
	 * create a new note object
	 * @param note
	 * @throws ParseException 
	 */
	public void create(NoteDTO noteDTO) throws ParseException{
		Note n = NoteMapper.getNoteFromDTO(noteDTO);
		noteRepo.saveAndFlush(n);
	}
	
	
	/**
	 * list all notes
	 * @return List<NoteDTO>
	 */
	public NoteListDTO getNotes(Integer page){
		Pageable pp = new PageRequest(page.intValue()-1,Constants.PAGE_SIZE);
		Page p = noteRepo.findAll(pp);
		List<Note> notes = p.getContent();
		NoteListDTO notesDTO = NoteMapper.getNoteDTOListFromNoteList(notes);
		return notesDTO;
	}
	
	/**
	 * @param id
	 * @return NoteDTO object that matches the passed Id
	 */
	public NoteDTO getNoteById(Long id){
		Note n = noteRepo.findOne(id);
		NoteDTO noteDto = NoteMapper.getNoteDTOFromNote(n);
		return noteDto;
	}
	
	/**
	 * @param d
	 * @return List<NoteDTO> that match the passed creation date.
	 */
	public NoteListDTO getNoteByCreationDate(Date d){
		List<Note> notes = noteRepo.findNoteByCreatedDate(d);
		NoteListDTO noteDTOList = NoteMapper.getNoteDTOListFromNoteList(notes);
		return noteDTOList ;
	}
	
	/**
	 * @param d
	 * @return List<NoteDTO> that match the passed creation date.
	 */
	public NoteListDTO getNoteByTag(String tag){
		NoteListDTO noteDTOList = null;
		try{
			Long id = Long.parseLong(tag);
			List<Note> notes = noteRepo.findNoteByTagId(id);
			noteDTOList = NoteMapper.getNoteDTOListFromNoteList(notes); 
			return noteDTOList;
		}catch(NumberFormatException e){		
			List<Note> notes =  noteRepo.findNoteByTagName(tag);
			noteDTOList = NoteMapper.getNoteDTOListFromNoteList(notes);
			return noteDTOList;
		}
		
	}
	
	
}
