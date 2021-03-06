package com.linjw.business.beans;
// default package
// Generated 2017-5-12 17:16:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * TAdmin generated by hbm2java
 */
public class TAdmin implements java.io.Serializable {

	private BigDecimal userid;
	private String username;
	private String userpw;

	public TAdmin() {
	}

	public TAdmin(BigDecimal userid) {
		this.userid = userid;
	}

	public TAdmin(BigDecimal userid, String username, String userpw) {
		this.userid = userid;
		this.username = username;
		this.userpw = userpw;
	}

	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpw() {
		return this.userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

}
