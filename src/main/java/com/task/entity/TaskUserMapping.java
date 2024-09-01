package com.task.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_user_mapping")
public class TaskUserMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "assigned_to_user")
	private User assignedTo;

	@OneToOne
	@JoinColumn(name = "assigned_by_user")
	private User assignedBy;

	@OneToOne
	@JoinColumn(name = "task_id")
	private Task task;

	@Column(name = "is_important")
	private Boolean isImportant;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "is_active")
	private Boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public User getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(User assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Boolean getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(Boolean isImportant) {
		this.isImportant = isImportant;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public TaskUserMapping(Long id, User assignedTo, User assignedBy, Task task, Boolean isImportant, Date createdOn,
			Boolean isActive) {
		super();
		this.id = id;
		this.assignedTo = assignedTo;
		this.assignedBy = assignedBy;
		this.task = task;
		this.isImportant = isImportant;
		this.createdOn = createdOn;
		this.isActive = isActive;
	}

	public TaskUserMapping() {
		super();
	}

}
