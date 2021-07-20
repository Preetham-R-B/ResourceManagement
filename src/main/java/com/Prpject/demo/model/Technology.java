package com.Prpject.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TECHNOLOGY")
public class Technology implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@ManyToMany(mappedBy = "TECHNOLOGY")
	@Column(name = "TECHNOLOGY_ID", updatable = false, nullable = false)
	private Long technologyId;

	@Column(name = "TECHNOLOGY_NAME")
	private String technologyName;

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

}
