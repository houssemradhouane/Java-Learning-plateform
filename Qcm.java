import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Collection;

public class Qcm extends Question{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    // The text of the question
    String question;

    // The correct answers
    Collection<String> correct_options;

    // The wrong answers
    Collection<String> wrong_options;

    // The course this question belongs to
    @ManyToOne
    Course course;

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

    public Collection<String> getCorrect_options() {
        return correct_options;
    }

    public void setCorrect_options(Collection<String> correct_option) {
        this.correct_options = correct_option;
    }

    public Collection<String> getWrong_options() {
        return wrong_options;
    }

    public void setWrong_options(Collection<String> wrong_options) {
        this.wrong_options = wrong_options;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addWrong_option(String wrong_option){
        this.getWrong_options().add(wrong_option);
    }

    public void addCorrect_option(String correct_option){
        this.getCorrect_options().add(correct_option);
    }
}
