package com.techniecode.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the esme_info database table.
 * 
 */
@Entity
@Table(name = "longapp_main_module_dependency")
public class LongappMainModuleDependency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer moduleDependencyId;

	@Column(name = "module_id")
	private Integer moduleId;

	@Column(name = "parent_id")
	private Integer parentId;

	@Column(name = "_created_at")
	private Date _createdAt;

	@Column(name = "_updated_at")
	private Date _updatedAt;

	@Column(name = "_created_by")
	private Integer _createdBy;

	@Column(name = "_updated_by")
	private Integer _updatedBy;

	public Integer getModuleDependencyId() {
		return moduleDependencyId;
	}

	public void setModuleDependencyId(Integer moduleDependencyId) {
		this.moduleDependencyId = moduleDependencyId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Date get_createdAt() {
		return _createdAt;
	}

	public void set_createdAt(Date _createdAt) {
		this._createdAt = _createdAt;
	}

	public Date get_updatedAt() {
		return _updatedAt;
	}

	public void set_updatedAt(Date _updatedAt) {
		this._updatedAt = _updatedAt;
	}

	public Integer get_createdBy() {
		return _createdBy;
	}

	public void set_createdBy(Integer _createdBy) {
		this._createdBy = _createdBy;
	}

	public Integer get_updatedBy() {
		return _updatedBy;
	}

	public void set_updatedBy(Integer _updatedBy) {
		this._updatedBy = _updatedBy;
	}

}