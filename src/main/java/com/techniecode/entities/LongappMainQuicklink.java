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
@Table(name = "longapp_main_quicklink")
public class LongappMainQuicklink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer quicklinkId;

	@Column(name = "navigation_id")
	private Integer navigationId;

	@Column(name = "index")
	private Integer index;

	@Column(name = "description")
	private String description;

	@Column(name = "_created_at")
	private Date _createdAt;

	@Column(name = "_updated_at")
	private Date _updatedAt;

	@Column(name = "_created_by")
	private Integer _createdBy;

	@Column(name = "_updated_by")
	private Integer _updatedBy;

	public Integer getQuicklinkId() {
		return quicklinkId;
	}

	public void setQuicklinkId(Integer quicklinkId) {
		this.quicklinkId = quicklinkId;
	}

	public Integer getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(Integer navigationId) {
		this.navigationId = navigationId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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