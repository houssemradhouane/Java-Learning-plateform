import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Student {

    // The student Id
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    int student_id;
    // The first name of the student
    String first_name;
    // The last name of the student
    String last_name;
    // The password
    String password;
    // The email
    String email;
    // the teacher
    @ManyToOne
    Teacher teacher;

    public Student() {
        super();
        this.teacher = new Teacher();
    }

    //defining the getters

    public int get_id() {
        return this.student_id;
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

    public Teacher get_teacher() {
        return this.teacher;
    }

    //defining the setters

    public void set_id(int id) {
        this.student_id = id;
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

    public void set_teacher(Teacher t) {
        this.teacher = t;
    }
}