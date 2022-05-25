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
     String email;
     // the teacher
     @OneToMany(mappedBy="teacher", fetch = FetchType.EAGER)
     Collection<Student> students;
     // Provided courses
     @ManyToMany(mappedBy="author", fetch = FetchType.EAGER)
     Collection<Course> courses;

    public Teacher() {
        super();
    }

     //defining the getters

    public int get_id() {
        return this.teacher_id;
    }

    public String get_firstname() {
        return this.first_name;
    }

    public String get_lastname() {
        return this.last_name;
    }

    public String get_password() {
        return this.password;
    }

    public String get_email() {
        return this.email;
    }

    public Collection<Student> get_students() {
        return this.students;
    }
    
    public Collection<Course> get_courses() {
        return this.courses;
    }

    //defining the setters

    public void set_id(int id) {
        this.teacher_id = id;
    }

    public void set_firstname(String fn) {
        this.first_name = fn;
    }

    public void set_lastname(String ln) {
        this.last_name = ln;
    }

    public void set_password(String pwd) {
        this.password = pwd;
    }

    public void set_email(String mail) {
        this.email = mail;
    }

    public void add_student(Student s) {
        this.students.add(s);
    }

    public void add_course(Course c) {
        this.courses.add(c);
    }
}
