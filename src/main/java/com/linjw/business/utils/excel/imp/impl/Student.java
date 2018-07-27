package com.linjw.business.utils.excel.imp.impl;

import com.linjw.business.utils.excel.imp.Column;

/**
 * A testing Class
 * @author Administrator
 *
 */
public class Student {

	@Column(actualColName="id")
	public String id;
	
	@Column(actualColName="年龄")
	private String age;
	
	@Column(actualColName="学分")
	private String score;
	
	@Column(actualColName="学号")
	private String no;
	
	@Column(actualColName="姓名")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
