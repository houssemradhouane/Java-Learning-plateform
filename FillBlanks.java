import javafx.util.Pair;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Collection;

public class FillBlanks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    // The text of the question
    String question_text;

    // The number of blanks to fill
    int blanks;

    // Options to fill the blanks in correct order
    Collection<Pair<Integer,String>> correct_options;

    // The course the question belongs to
    @ManyToOne
    Course course;

    

}
