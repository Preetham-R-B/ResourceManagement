package com.Prpject.demo.model;

//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "TECHNOLOGY")
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TECHNOLOGY_ID", updatable = false, nullable = false)
	private int technologyId;

	@Column(name = "TECHNOLOGY_NAME")
	private String technologyName;

	public int getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

}
