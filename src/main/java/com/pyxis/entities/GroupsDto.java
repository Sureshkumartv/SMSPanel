package com.pyxis.entities;

public class GroupsDto {
	
	
//	    /**
//	     * @return the users
//	     */
//	    public Users getUsers() {
//	        return users;
//	    }
//	
//	    /**
//	     * @param users the users to set
//	     */
//	    public void setUsers(Users users) {
//	        this.users = users;
//	    }
//	
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    @Column(name = "GROUPSNO")
//	    private Long groupsno;
//	
//	    @Column(name = "GROUPNAME")
//	    private String groupname;
//	
//	    @Column(name = "CREATEDBY")
//	    private Long createdby;
//	
//	    @Column(name = "CREATEDATE")
//	    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//	    private Date createddate;
//	
//	    @OneToOne(optional = false)
//	    @JoinColumn(name = "CREATEDBY", insertable = false, updatable = false)
//	    private Users users;
//	    
//	    @OneToMany(mappedBy="groups" , fetch = FetchType.LAZY)
//	    private List<Contacts> groupContacts;
//	    
//	    @Transient
//	    private Integer contactsCount;
//	
//	    public Groups(String groupname, Long createdby, Date createddate, Users users) {
//	        this.groupname = groupname;
//	        this.createdby = createdby;
//	        this.createddate = createddate;
//	        this.users = users;
//	    }
//	
//	    public Groups() {
//	        System.out.println("Groups Constructor");
//	    }
//	
//	    /**
//	     * @return the groupsno
//	     */
//	    public Long getGroupsno() {
//	        return groupsno;
//	    }
//	
//	    /**
//	     * @param groupsno the groupsno to set
//	     */
//	    public void setGroupsno(Long groupsno) {
//	        this.groupsno = groupsno;
//	    }
//	
//	    /**
//	     * @return the groupname
//	     */
//	    public String getGroupname() {
//	        return groupname;
//	    }
//	
//	    /**
//	     * @param groupname the groupname to set
//	     */
//	    public void setGroupname(String groupname) {
//	        this.groupname = groupname;
//	    }
//	
//	    /**
//	     * @return the createdby
//	     */
//	    public Long getCreatedby() {
//	        return createdby;
//	    }
//	
//	    /**
//	     * @param createdby the createdby to set
//	     */
//	    public void setCreatedby(Long createdby) {
//	        this.createdby = createdby;
//	    }
//	
//	    /**
//	     * @return the createddate
//	     */
//	    public Date getCreateddate() {
//	        return createddate;
//	    }
//	
//	    /**
//	     * @param createddate the createddate to set
//	     */
//	    public void setCreateddate(Date createddate) {
//	        this.createddate = createddate;
//	    }
//	
//	    @JsonIgnore
//		public List<Contacts> getGroupContacts() {
//			return groupContacts;
//		}
//	
//		public void setGroupContacts(List<Contacts> groupContacts) {
//			this.groupContacts = groupContacts;
//		}
//	
//		@Transient
//		public Integer getContactsCount() {
//			if(null != this.groupContacts){
//				return this.groupContacts.size();
//			}
//			return contactsCount;
//		}
//	
//		public void setContactsCount(Integer contactsCount) {
//			this.contactsCount = contactsCount;
//		}
		
		
		
	
	//    /**
	//     * @return the users
	//     */
	//    public Users getUsers() {
	//        return users;
	//    }
	//
	//    /**
	//     * @param users the users to set
	//     */
	//    public void setUsers(Users users) {
	//        this.users = users;
	//    }
	
}

