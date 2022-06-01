package src;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Teacher {

     // The teacher Id
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     int teacher_id;
     // The first name of the student
     String first_name;
     // The last name of the student
     String last_name;
     // The password
     String password;
     // The email
     String username;
     // the teacher
     @OneToMany(mappedBy="teacher", fetch = FetchType.EAGER)
     Collection<Student> students;
     // Provided courses
     @ManyToMany(mappedBy="author", fetch = FetchType.EAGER)
     Collection<Course> courses;
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<Student> getStudents() {
		return students;
	}
	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	public Collection<Course> getCourses() {
		return courses;
	}
	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

    public void add_student(Student s) {
    	this.getStudents().add(s);
    }
    
    public void add_course(Course c) {
    	this.getCourses().add(c);
    }
}
