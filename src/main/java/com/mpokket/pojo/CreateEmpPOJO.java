package com.mpokket.pojo;

/**
 * 
 * @author USER
 *
 */

public class CreateEmpPOJO {

	private String name;

	private String salary;

	private String age;

	private int id;

	public CreateEmpPOJO(String name, String salary, String age, int id) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
