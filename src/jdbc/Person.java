package jdbc;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	private int id;
	private String name;
	private String sex;
	private String email;
	private Date birthday;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, String sex, String email, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.birthday = birthday;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", email=" + email + ", birthday=" + birthday + "]";
	}
	
	
	
}
