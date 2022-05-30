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
    @OneToMany
    Collection<Pair> correct_options;

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

    public Collection<Pair> getCorrect_options() {
        return correct_options;
    }

    public void setCorrect_options(Collection<Pair> correct_options) {
        this.correct_options = correct_options;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addCorrect_option(int blank_num,String correct_option){
        Pair noption = new Pair();
        noption.setLeft(blank_num);
        noption.setRight(correct_option);
        this.getCorrect_options().add(noption);
    }
}
