package com.linjw.spring.conversion.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;

public class Person {

	private String name;
	@NumberFormat(pattern="0k")
    private int age;
    @DateTimeFormat(iso=ISO.DATE)
    private Date hiredDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getHiredDate() {
		return hiredDate;
	}
	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", hiredDate=" + hiredDate + "]";
	}
	
}
