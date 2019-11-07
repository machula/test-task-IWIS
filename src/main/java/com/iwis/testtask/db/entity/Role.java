package com.iwis.testtask.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
		
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Enumerated(EnumType.STRING)
    private RoleType name;
    private String description;
    private Long createdOn;
    private Long modifiedOn;
    
    public Role() {}
    
	public Role(long id, RoleType name, String description, Long createdOn, Long modifiedOn) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RoleType getName() {
		return name;
	}

	public void setName(RoleType name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public Long getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
    
    

}
