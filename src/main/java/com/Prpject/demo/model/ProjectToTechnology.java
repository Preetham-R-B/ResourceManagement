package com.Prpject.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REQUIRED_PROJECT_SKILL")
public class ProjectToTechnology {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
	private Project project;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TECHNOLOGY_ID", referencedColumnName = "TECHNOLOGY_ID")
	private Technology technology;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

}
