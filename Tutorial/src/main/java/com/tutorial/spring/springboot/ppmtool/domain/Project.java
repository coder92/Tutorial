package com.tutorial.spring.springboot.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Project Name is required.")
	private String projectName;
	
	@NotBlank(message="Project Identifier is required.")
	@Size(min =4, max =5, message="Please use 4 to 5 characters only.")
	@Column(updatable = false, unique=true)
	private String projectIdentifier;
	
	@NotBlank(message = "project description is required.")
	private String description;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date startDate;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date endDate;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date createAt;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date updateAt;
	
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
}