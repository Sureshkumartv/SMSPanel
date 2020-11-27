package com.pyxis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the image_uploads database table.
 * 
 */
@Entity
@Table(name="image_uploads")
//@NamedQuery(name="ImageUpload.findAll", query="SELECT i FROM ImageUpload i")
public class ImageUpload implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="image_uploads_id", unique=true, nullable=false)
	private Integer imageUploadsId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_date", nullable=false)
	private Timestamp createdDate;

	@Column(name="image_path", length=500)
	private String imagePath;
	
	@Column(name="type")
	private Integer type;

	public ImageUpload() {
	}

	public Integer getImageUploadsId() {
		return this.imageUploadsId;
	}

	public void setImageUploadsId(Integer imageUploadsId) {
		this.imageUploadsId = imageUploadsId;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}