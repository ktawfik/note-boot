package com.note.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.note.dto.NoteDTO;
import com.note.dto.NoteListDTO;
import com.note.model.Note;
import com.note.model.Tag;


/**
 * @author ktawfik
 *
 */
public class NoteMapper {

	/**
	 * Construct Note object from NoteDTO
	 * @param noteDTO
	 * @return
	 * @throws ParseException 
	 */
	public static Note getNoteFromDTO(NoteDTO noteDTO) throws ParseException{
		Note n = new Note();
		
		n.setDescription(noteDTO.getDescription());
		n.setTitle(noteDTO.getTitle());
		n.setTags(constructTagsWithIdOnly(noteDTO.getTag()));
		n.setCreatedDate(Constants.SDF_DD_MM_YYYY.parse(noteDTO.getCreatedDate()));
		
		return n;
	}
	
	/**
	 * This method convert Note to NoteDTO
	 * @param note
	 * @return NoteDTO
	 */
	public static NoteDTO getNoteDTOFromNote(Note note){
		NoteDTO noteDto = new NoteDTO();
		
		noteDto.setId(note.getId());
		noteDto.setDescription(note.getDescription());
		noteDto.setTitle(note.getTitle());
		noteDto.setCreatedDate(Constants.SDF_DD_MM_YYYY.format(note.getCreatedDate()));
		noteDto.setTag(getTagsIdsFromTagList(note.getTags()));
		
		return noteDto;
	}
	
	/**
	 * This is a helper method that converts list of notes to list of notedto
	 * @param notes
	 * @return List<NoteDTO>
	 */
	public static NoteListDTO getNoteDTOListFromNoteList(List<Note> notes){
		if(Util.isNullOrEmptyCollection(notes)){
			return null;
		}
		List<NoteDTO> noteDTOList = new ArrayList<NoteDTO>();
		for(Note n : notes){
			noteDTOList.add(getNoteDTOFromNote(n));
		}
		NoteListDTO wrapper = new NoteListDTO();
		wrapper.setNotes(noteDTOList);
		return wrapper;
	}
	
	
	
	
	
	/**
	 * This method convert the Tags list in the note object to list of Ids.
	 * @param note
	 * @return List<Long>
	 */
	private static List<Long> getTagsIdsFromTagList(List<Tag> tagsList){
		if(Util.isNullOrEmptyCollection(tagsList)){
			return null;
		}
		List<Long> tagsIds = new ArrayList<Long>();
		for(Tag t:tagsList){
			tagsIds.add(t.getId());
		}
		return tagsIds;
	}
	
	/**
	 * This method construct empty tags object that only contains ID.
	 * @param ids
	 * @return List<Tag>
	 */
	private static List<Tag> constructTagsWithIdOnly(List<Long> tagsIds) {
		if(Util.isNullOrEmptyCollection(tagsIds)){
			return null;
		}
		List<Tag> tagList = new ArrayList<Tag>();
		Tag t;
		for(Long id : tagsIds){
			t = new Tag();
			t.setId(id);
			tagList.add(t);
		}
		return tagList;
	}
	
}
