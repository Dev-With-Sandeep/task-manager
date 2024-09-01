package com.task.dto;

import java.util.Date;

public class TaskRequestDto {

	private Long id;

	private String name;

	private String description;

	private Date taskDate;

	private Long assignedTo;

	private Long assignedBy;

	private Boolean isImportant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Long getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Long assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(Boolean isImportant) {
		this.isImportant = isImportant;
	}

	public TaskRequestDto(Long id, String name, String description, Date taskDate, Long assignedTo, Long assignedBy,
			Boolean isImportant) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.taskDate = taskDate;
		this.assignedTo = assignedTo;
		this.assignedBy = assignedBy;
		this.isImportant = isImportant;
	}

	public TaskRequestDto() {
		super();
	}

}
