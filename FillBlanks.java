package src;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class FillBlanks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    // The text ozf the question
    String question_text;

    // The number of blanks to fill
    int blanks;

    // Options to fill the blanks in correct order
    String foption;
    String soption;
    String toption;
    String fooption;

    // The course the question belongs to
    @ManyToOne
    Course course;

    public FillBlanks() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public int getBlanks() {
        return blanks;
    }

    public void setBlanks(int blanks) {
        this.blanks = blanks;
    }


    public String getFoption() {
		return foption;
	}

	public void setFoption(String foption) {
		this.foption = foption;
	}

	public String getSoption() {
		return soption;
	}

	public void setSoption(String soption) {
		this.soption = soption;
	}

	public String getToption() {
		return toption;
	}

	public void setToption(String toption) {
		this.toption = toption;
	}

	public String getFooption() {
		return fooption;
	}

	public void setFooption(String fooption) {
		this.fooption = fooption;
	}

	public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
