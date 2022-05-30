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

    // The correct answers
    @OneToMany
    Collection<Option> correct_options;

    // The wrong answers
    @OneToMany
    Collection<Option> wrong_options;

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

    public Collection<Option> getCorrect_options() {
        return correct_options;
    }

    public void setCorrect_options(Collection<Option> correct_option) {
        this.correct_options = correct_option;
    }

    public Collection<Option> getWrong_options() {
        return wrong_options;
    }

    public void setWrong_options(Collection<Option> wrong_options) {
        this.wrong_options = wrong_options;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addWrong_option(Option wrong_option){
        this.getWrong_options().add(wrong_option);
    }

    public void addCorrect_option(String correct_option_t){
    	Option correct_option = new Option();
    	correct_option.setValue(correct_option_t);
        this.getCorrect_options().add(correct_option);
    }
}
