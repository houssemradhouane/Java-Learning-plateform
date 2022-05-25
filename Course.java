package src;

import javax.persistence.*;

import java.util.Collection;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int course_id;

    // Name of the course
    String course_name;

    // Category of the course
    cCategory course_category;

    // Boolean to indicate if the course is done or not
    Boolean done;

    // Questions related to the course
    @OneToMany(mappedBy="course")
    Collection<Question> questions;

    @OneToMany(mappedBy="course")
    Collection<Qcm> qcms;

    @OneToMany(mappedBy="course")
    Collection<FillBlanks> fillblanks;

    public Course() {
        super();
    }

    // defining getters and setters
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public cCategory getCourse_category() {
        return course_category;
    }

    public void setCourse_category(cCategory course_category) {
        this.course_category = course_category;
    }

    public Collection<Question> getCourse_content() {
        return this.questions;
    }

    public void addCourse_content(Question course_content) {
        this.questions.add(course_content);
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
