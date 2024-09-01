package com.task.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponseDto {

	private Long taskUserId;

	private Long taskId;

	private String taskName;

	private String taskDescription;

	private Date taskDate;

	private String assignedTo;

	private String assignedBy;

	private Boolean isActive;

	public Long getTaskUserId() {
		return taskUserId;
	}

	public void setTaskUserId(Long taskUserId) {
		this.taskUserId = taskUserId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public TaskResponseDto(Long taskUserId, Long taskId, String taskName, String taskDescription, Date taskDate,
			String assignedTo, String assignedBy, Boolean isActive) {
		super();
		this.taskUserId = taskUserId;
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskDate = taskDate;
		this.assignedTo = assignedTo;
		this.assignedBy = assignedBy;
		this.isActive = isActive;
	}

	public TaskResponseDto(Long taskId, String taskName, String taskDescription, Date taskDate, Boolean isActive) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskDate = taskDate;
		this.isActive = isActive;
	}

}
