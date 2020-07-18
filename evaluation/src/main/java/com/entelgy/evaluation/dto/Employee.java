package com.entelgy.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	private int id;
	@JsonProperty("employee_name")
	private String name;
	@JsonProperty("employee_salary")
	private double salary;
	@JsonProperty("employee_age")
	private long age;
	@JsonProperty("profile_image")
	private String profileImage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

}
