package com.pyxis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the esme_info database table.
 * 
 */
@Entity
@Table(name="esme_info")
public class EsmeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer allownumeric;

	@Column(nullable=false)
	private Timestamp creationdate;

	@Column(length=15)
	private String defaultsenderaddress;

	@Column(nullable=false)
	private Integer destnpi;

	@Column(nullable=false)
	private Integer destton;

	@Column(nullable=false, length=20)
	private String hostname;

	@Column(nullable=false, length=15)
	private String password;

	@Column(nullable=false)
	private Integer port;

	@Column(nullable=false)
	private Integer receiver;

	@Column(nullable=false)
	private Integer srcnpi;

	@Column(nullable=false)
	private Integer srcton;

	@Column(nullable=false)
	private Integer status;

	@Column(nullable=false, length=15)
	private String systemid;

	@Column(nullable=false, length=20)
	private String systemtype;

	@Column(nullable=false)
	private Integer transceiver;

	@Column(nullable=false)
	private Integer transmitter;

	@Column(length=5)
	private String type;

	@Column(nullable=false)
	private Integer usedefaultsender;

	public EsmeInfo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAllownumeric() {
		return this.allownumeric;
	}

	public void setAllownumeric(Integer allownumeric) {
		this.allownumeric = allownumeric;
	}

	public Timestamp getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Timestamp creationdate) {
		this.creationdate = creationdate;
	}

	public String getDefaultsenderaddress() {
		return this.defaultsenderaddress;
	}

	public void setDefaultsenderaddress(String defaultsenderaddress) {
		this.defaultsenderaddress = defaultsenderaddress;
	}

	public Integer getDestnpi() {
		return this.destnpi;
	}

	public void setDestnpi(Integer destnpi) {
		this.destnpi = destnpi;
	}

	public Integer getDestton() {
		return this.destton;
	}

	public void setDestton(Integer destton) {
		this.destton = destton;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	public Integer getSrcnpi() {
		return this.srcnpi;
	}

	public void setSrcnpi(Integer srcnpi) {
		this.srcnpi = srcnpi;
	}

	public Integer getSrcton() {
		return this.srcton;
	}

	public void setSrcton(Integer srcton) {
		this.srcton = srcton;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSystemid() {
		return this.systemid;
	}

	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}

	public String getSystemtype() {
		return this.systemtype;
	}

	public void setSystemtype(String systemtype) {
		this.systemtype = systemtype;
	}

	public Integer getTransceiver() {
		return this.transceiver;
	}

	public void setTransceiver(Integer transceiver) {
		this.transceiver = transceiver;
	}

	public Integer getTransmitter() {
		return this.transmitter;
	}

	public void setTransmitter(Integer transmitter) {
		this.transmitter = transmitter;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUsedefaultsender() {
		return this.usedefaultsender;
	}

	public void setUsedefaultsender(Integer usedefaultsender) {
		this.usedefaultsender = usedefaultsender;
	}

}