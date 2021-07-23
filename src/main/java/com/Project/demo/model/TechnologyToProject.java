package com.Project.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "REQUIRED_PROJECT_SKILL")
public class TechnologyToProject {

	@EmbeddedId
	TechnologyToProjectPK technologyToProjectPK;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("projectId")
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("technologyId")
	@JoinColumn(name = "TECHNOLOGY_ID", referencedColumnName = "TECHNOLOGY_ID")
	private Technology technology;

	public TechnologyToProject() {
	}

	public TechnologyToProject(TechnologyToProjectPK technologyToProjectPK, Project project, Technology technology) {
		super();
		this.technologyToProjectPK = technologyToProjectPK;
		this.project = project;
		this.technology = technology;
	}

	public TechnologyToProjectPK getTechnologyToProjectPK() {
		return technologyToProjectPK;
	}

	public void setTechnologyToProjectPK(TechnologyToProjectPK technologyToProjectPK) {
		this.technologyToProjectPK = technologyToProjectPK;
	}

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
