package com.note.dto;

import java.util.List;

public class NoteDTO {

	private Long id;
	
	private String title;
	
	private String description;
	
	private String createdDate;
	
	private List<Long> tag;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public List<Long> getTag() {
		return tag;
	}

	public void setTag(List<Long> tag) {
		this.tag = tag;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
