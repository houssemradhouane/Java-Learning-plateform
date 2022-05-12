import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Qcm extends Question{

    @Id
    @GeneratedValue(strategy = GenerationType.Identity)
    int id;

    String question
}
