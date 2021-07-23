package com.Project.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TechnologyToProjectPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TECHNOLOGY_ID")
	private Long technologyId;

	@Column(name = "PROJECT_ID")
	private Long projectId;

	public TechnologyToProjectPK() {
	}

	public TechnologyToProjectPK(Long technologyId, Long projectId) {
		this.technologyId = technologyId;
		this.projectId = projectId;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + ((technologyId == null) ? 0 : technologyId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechnologyToProjectPK other = (TechnologyToProjectPK) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (technologyId == null) {
			if (other.technologyId != null)
				return false;
		} else if (!technologyId.equals(other.technologyId))
			return false;
		return true;
	}

}
