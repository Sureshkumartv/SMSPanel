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
@Table(name="longapp_main_widget")
public class LongappMainWidget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	  private Integer widgetId;
	
	@Column(name = "widget_name")
	private String widgetName;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "authorization_id")
	private Integer authorizationId;
	
	@Column(name = "active")
	private Integer active;
	
	@Column(name = "index")
	private Integer index;
	
	@Column(name = "is_static")
	private Integer isStatic;
	
	@Column(name = "static_content")
	private String staticContent;
	
	@Column(name = "slug")
	private String slug;
	
	@Column(name = "_created_at")
	private Date _createdAt;
	
	@Column(name = "_updated_at")
	private Date _updatedAt;
	
	@Column(name = "_created_by")
	private Integer _createdBy;
	
	@Column(name = "_updated_by")
	private Integer _updatedBy;
	
	@Column(name = "group_widget")
	private String groupWidget;

	public Integer getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(Integer widgetId) {
		this.widgetId = widgetId;
	}

	public String getWidgetName() {
		return widgetName;
	}

	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getAuthorizationId() {
		return authorizationId;
	}

	public void setAuthorizationId(Integer authorizationId) {
		this.authorizationId = authorizationId;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getIsStatic() {
		return isStatic;
	}

	public void setIsStatic(Integer isStatic) {
		this.isStatic = isStatic;
	}

	public String getStaticContent() {
		return staticContent;
	}

	public void setStaticContent(String staticContent) {
		this.staticContent = staticContent;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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

	public String getGroupWidget() {
		return groupWidget;
	}

	public void setGroupWidget(String groupWidget) {
		this.groupWidget = groupWidget;
	}

}