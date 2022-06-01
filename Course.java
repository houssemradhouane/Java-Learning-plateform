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
    
    String course_content;
    
    String course_link;

    // Category of the course
    //cCategory course_category;

    // Boolean to indicate if the course is done or not
    Boolean done;

    // Questions related to the course
    @OneToMany(fetch=FetchType.EAGER, mappedBy="course", cascade = CascadeType.ALL)
    Collection<Question> questions;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="course", cascade = CascadeType.ALL)
    Collection<Qcm> qcms;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="course", cascade = CascadeType.ALL)
    Collection<FillBlanks> fillblanks;

    @ManyToOne
    Teacher author;

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
    
    public String getCourse_link() {
		return course_link;
	}

	public void setCourse_link(String course_link) {
		this.course_link = course_link;
	}

	public void setCourse_content(String course_content) {
		this.course_content = course_content;
	}

	public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


    public String getCourse_content() {
        return this.course_content;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public Collection<Qcm> getQcms() {
        return qcms;
    }

    public void setQcms(Collection<Qcm> qcms) {
        this.qcms = qcms;
    }

    public Collection<FillBlanks> getFillblanks() {
        return fillblanks;
    }

    public void setFillblanks(Collection<FillBlanks> fillblanks) {
        this.fillblanks = fillblanks;
    }

    public Teacher getAuthor() {
        return author;
    }

    public void setAuthor(Teacher author) {
        this.author = author;
    }

    public void addQcm(Qcm qcm) {
        this.getQcms().add(qcm);
    }

    public void addFillBlanks(FillBlanks fb){
        this.getFillblanks().add(fb);
    }

    public void addQuestion(Question q) {
        this.getQuestions().add(q);
    }
}
