package com.taskmanager.taskmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "teams")
public class Teams implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer teamsid;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="departament_id")
	private Integer departament_id;

	public Integer getTeamsid() {
		return teamsid;
	}

	public void setTeamsid(Integer teamsid) {
		this.teamsid = teamsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepartament_id() {
		return departament_id;
	}

	public void setDepartament_id(Integer departament_id) {
		this.departament_id = departament_id;
	}
	
}
