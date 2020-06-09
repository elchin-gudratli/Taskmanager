package com.taskmanager.taskmanager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "tasks")
public class Tasks implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start_date;
	
	@Column(name = "deadline")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	
	@Column(name = "status_id")
	private Integer status_id;
	
	@Column(name = "project_id")
	private Integer project_id;
	
	@Column(name = "type_id")
	private Integer type_id;
	
	@Column(name = "all_chk")
	private Boolean all_chk;

	@Column(name = "deadline_hour")
	private String deadline_hour;
	
	@Column(name = "deadline_update")
	private Boolean deadline_update;
	
	@Column(name = "todo_list")
	private Boolean todo_list;
	
	@Column(name = "created_by")
	private Integer created_by;
	
	@Column(name = "created_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_time;
	
	@Column(name = "edited_by")
	private Integer edited_by;
	
	@Column(name = "delivered")
	private Boolean delivered;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public Boolean getAll_chk() {
		return all_chk;
	}

	public void setAll_chk(Boolean all_chk) {
		this.all_chk = all_chk;
	}

	public String getDeadline_hour() {
		return deadline_hour;
	}

	public void setDeadline_hour(String deadline_hour) {
		this.deadline_hour = deadline_hour;
	}

	public Boolean getDeadline_update() {
		return deadline_update;
	}

	public void setDeadline_update(Boolean deadline_update) {
		this.deadline_update = deadline_update;
	}

	public Boolean getTodo_list() {
		return todo_list;
	}

	public void setTodo_list(Boolean todo_list) {
		this.todo_list = todo_list;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Integer getEdited_by() {
		return edited_by;
	}

	public void setEdited_by(Integer edited_by) {
		this.edited_by = edited_by;
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}
}
