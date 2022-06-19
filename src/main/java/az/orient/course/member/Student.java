package az.orient.course.member;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;

    private String surname;

    private Integer point;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student() {
	}

	public Student(Long id, String name, String surname, Integer point) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.point = point;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return id+" "+name+" "+surname+" "+point;
	}
    
    

}
