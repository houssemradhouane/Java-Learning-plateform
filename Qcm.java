package src;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Qcm{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    // The text of the question
    String question;

    // The options
    String coption;
    String fwoption;
    String swoption;


    // The course this question belongs to
    @ManyToOne
    Course course;

    public Qcm() {
        super();
    }

    // defining setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCoption() {
		return coption;
	}

	public void setCoption(String coption) {
		this.coption = coption;
	}

	public String getFwoption() {
		return fwoption;
	}

	public void setFwoption(String fwoption) {
		this.fwoption = fwoption;
	}

	public String getSwoption() {
		return swoption;
	}

	public void setSwoption(String swoption) {
		this.swoption = swoption;
	}

	public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
