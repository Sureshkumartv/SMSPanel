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
@Table(name = "longapp_main_navigation")
public class LongappMainNavigation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer navigationId;

	@Column(name = "navigation_name")
	private String navigationName;

	@Column(name = "parent_id")
	private Integer parentId;

	@Column(name = "title")
	private String title;

	@Column(name = "bootstrap_glyph")
	private String bootstrapGlyph;

	@Column(name = "page_title")
	private String pageTitle;

	@Column(name = "page_keyword")
	private String pageKeyword;

	@Column(name = "description")
	private String description;

	@Column(name = "url")
	private String url;

	@Column(name = "authorization_id")
	private String authorizationId;

	@Column(name = "active")
	private Integer active;

	@Column(name = "index")
	private Integer index;

	@Column(name = "is_static")
	private Integer isStatic;

	@Column(name = "static_content")
	private String staticContent;

	@Column(name = "only_content")
	private Integer onlyContent;

	@Column(name = "default_theme")
	private String defaultTheme;

	@Column(name = "default_layout")
	private String defaultLayout;

	@Column(name = "notif_url")
	private String notifUrl;

	@Column(name = "children")
	private String children;

	@Column(name = "hidden")
	private Integer hidden;

	@Column(name = "custom_style")
	private String customStyle;

	@Column(name = "custom_script")
	private String customScript;

	@Column(name = "page_twitter_card")
	private String pageTwitterCard;

	@Column(name = "page_image")
	private String pageImage;

	@Column(name = "page_author")
	private String pageAuthor;

	@Column(name = "page_type")
	private String pageType;

	@Column(name = "page_fb_admin")
	private String pageFbAdmin;

	@Column(name = "page_twitter_publisher_handler")
	private String pageTwitterPublisherHandler;

	@Column(name = "page_twitter_author_handler")
	private String pageTwitterAuthorHandler;

	@Column(name = "_created_at")
	private Date _createdAt;

	@Column(name = "_updated_at")
	private Date _updatedAt;

	@Column(name = "_created_by")
	private Integer _createdBy;

	@Column(name = "_updated_by")
	private Integer _updatedBy;

	@Column(name = "group_navigation")
	private String groupNavigation;

	public Integer getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(Integer navigationId) {
		this.navigationId = navigationId;
	}

	public String getNavigationName() {
		return navigationName;
	}

	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBootstrapGlyph() {
		return bootstrapGlyph;
	}

	public void setBootstrapGlyph(String bootstrapGlyph) {
		this.bootstrapGlyph = bootstrapGlyph;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageKeyword() {
		return pageKeyword;
	}

	public void setPageKeyword(String pageKeyword) {
		this.pageKeyword = pageKeyword;
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

	public String getAuthorizationId() {
		return authorizationId;
	}

	public void setAuthorizationId(String authorizationId) {
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

	public Integer getOnlyContent() {
		return onlyContent;
	}

	public void setOnlyContent(Integer onlyContent) {
		this.onlyContent = onlyContent;
	}

	public String getDefaultTheme() {
		return defaultTheme;
	}

	public void setDefaultTheme(String defaultTheme) {
		this.defaultTheme = defaultTheme;
	}

	public String getDefaultLayout() {
		return defaultLayout;
	}

	public void setDefaultLayout(String defaultLayout) {
		this.defaultLayout = defaultLayout;
	}

	public String getNotifUrl() {
		return notifUrl;
	}

	public void setNotifUrl(String notifUrl) {
		this.notifUrl = notifUrl;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public Integer getHidden() {
		return hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

	public String getCustomStyle() {
		return customStyle;
	}

	public void setCustomStyle(String customStyle) {
		this.customStyle = customStyle;
	}

	public String getCustomScript() {
		return customScript;
	}

	public void setCustomScript(String customScript) {
		this.customScript = customScript;
	}

	public String getPageTwitterCard() {
		return pageTwitterCard;
	}

	public void setPageTwitterCard(String pageTwitterCard) {
		this.pageTwitterCard = pageTwitterCard;
	}

	public String getPageImage() {
		return pageImage;
	}

	public void setPageImage(String pageImage) {
		this.pageImage = pageImage;
	}

	public String getPageAuthor() {
		return pageAuthor;
	}

	public void setPageAuthor(String pageAuthor) {
		this.pageAuthor = pageAuthor;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getPageFbAdmin() {
		return pageFbAdmin;
	}

	public void setPageFbAdmin(String pageFbAdmin) {
		this.pageFbAdmin = pageFbAdmin;
	}

	public String getPageTwitterPublisherHandler() {
		return pageTwitterPublisherHandler;
	}

	public void setPageTwitterPublisherHandler(String pageTwitterPublisherHandler) {
		this.pageTwitterPublisherHandler = pageTwitterPublisherHandler;
	}

	public String getPageTwitterAuthorHandler() {
		return pageTwitterAuthorHandler;
	}

	public void setPageTwitterAuthorHandler(String pageTwitterAuthorHandler) {
		this.pageTwitterAuthorHandler = pageTwitterAuthorHandler;
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

	public String getGroupNavigation() {
		return groupNavigation;
	}

	public void setGroupNavigation(String groupNavigation) {
		this.groupNavigation = groupNavigation;
	}
	

}