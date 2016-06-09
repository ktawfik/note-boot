package com.note.api;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.note.dto.NoteDTO;
import com.note.dto.NoteListDTO;
import com.note.service.NoteService;

@RestController
@RequestMapping("api/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value="page/{page}", method = RequestMethod.GET)
	@ResponseBody
	public NoteListDTO getNotes(@PathVariable("page") Integer page) {
 		return noteService.getNotes(page);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ResponseBody
	public NoteDTO getNoteById(@PathVariable("id") Long id) {
		return noteService.getNoteById(id);
	}
	
	@RequestMapping(value="created/{date}",method = RequestMethod.GET)
	@ResponseBody
	public NoteListDTO getNoteCreationDate(@PathVariable("date") @DateTimeFormat(pattern="dd-MM-yyyy") Date date) throws ParseException {
		return noteService.getNoteByCreationDate(date);
	}
	
	/**
	 * list all note that have either this tag id or tag name
	 * @param date
	 * @return
	 */
	@RequestMapping(value="tag/{tag}",method = RequestMethod.GET)
	@ResponseBody
	public NoteListDTO getNoteByTag(@PathVariable("tag") String tag) {
		return noteService.getNoteByTag(tag);
	}
	
	/**
	 * Save new Note in the db
	 * @param note
	 * @throws ParseException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void create(@RequestBody NoteDTO note) throws ParseException {
		noteService.create(note);
	}

}
