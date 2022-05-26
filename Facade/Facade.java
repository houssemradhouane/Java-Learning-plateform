package src;

import javafx.util.Pair;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Singleton
public class Facade {

    @PersistenceContext
    private EntityManager em;

    public void addStudent(String n, String lastn, String pwd, String m){
        Student s = new Student();
        s.set_firstname(n);
        s.set_lastname(lastn);
        s.set_password(pwd);
        s.set_email(m);
        em.persist(s);
    }

    public void addTeacher(String n, String lastn, String pwd, String m){
        Teacher t = new Teacher();
        t.set_firstname(n);
        t.set_lastname(lastn);
        t.set_password(pwd);
        t.set_email(m);
        em.persist(t);
    }

    public void linkTeacherStudent(int sid, int tid) {
        Teacher t = em.find(Teacher.class,tid);
        Student s = em.find(Student.class,sid);
        s.set_teacher(t);
        t.add_student(s);
    }

    public Collection<Student> listStudents(int tid) {
        Teacher t = em.find(Teacher.class,tid);
        return t.get_students();
    }

    public Collection<Student> listAllStudents() {
        TypedQuery<Student> req = em.createQuery("Select s from Student s", Student.class);
        return req.getResultList();
    }

    public Collection<Teacher> listAllTeachers() {
        TypedQuery<Teacher> req = em.createQuery("Select t from Teacher t", Teacher.class);
        return req.getResultList();
    }

    public boolean checkTeacherLogin(String email, String pwd) {
        TypedQuery<Teacher> req = em.createQuery("Select t from Teacher t where t.email=" + email
                +" and t.password="+pwd, Teacher.class);
        return !req.getResultList().isEmpty();
    }

    public boolean checkStudentLogin(String email, String pwd) {
        TypedQuery<Student> req = em.createQuery("Select s from Student s where s.email=" + email
                +" and s.password="+pwd, Student.class);
        return !req.getResultList().isEmpty();
    }

    public void addCourse(String name, cCategory c){
        Course course = new Course();
        course.setCourse_name(name);
        course.setCourse_category(c);
        course.setDone(false);
        em.persist(course);
    }

    public void linkTeacherCourse(int cid, int tid) {
        Teacher t = em.find(Teacher.class,tid);
        Course c = em.find(Course.class,cid);
        c.setAuthor(t);
        t.add_course(c);
    }

    public Collection<Course> listCourses(int tid) {
        Teacher t = em.find(Teacher.class,tid);
        return t.get_courses();
    }

    public Collection<Course> listAllCourses() {
        TypedQuery<Course> req = em.createQuery("Select c from Course c", Course.class);
        return req.getResultList();
    }

    public void addQCM(String q, Collection<String> correcto, Collection<String> wrongo, int cid){
        Qcm qcm = new Qcm();
        qcm.setQuestion(q);
        qcm.setCorrect_options(correcto);
        qcm.setWrong_options(wrongo);
        em.persist(qcm);
        Course c = em.find(Course.class,cid);
        qcm.setCourse(c);
        c.addQcm(qcm);
    }

    public void addQestion(String q, String answer, int cid){
        Question question = new Question();
        question.setQuestion_text(q);
        question.setAnswer(answer);
        em.persist(question);
        Course c = em.find(Course.class,cid);
        question.setCourse(c);
        c.addQuestion(question);
    }

    public void addFillBlanks(String q, Collection<Pair<Integer,String>> correct_options, int cid){
        FillBlanks fb = new FillBlanks();
        fb.setQuestion_text(q);
        fb.setCorrect_options(correct_options);
        em.persist(fb);
        Course c = em.find(Course.class,cid);
        fb.setCourse(c);
        c.addFillBlanks(fb);
    }

    public int getFbScore(FillBlanks fb, Collection<Pair<Integer,String>> proposition) {
        Collection<Pair<Integer,String>> correct_order = fb.getCorrect_options();
        int score = 0;
        for (Pair<Integer,String> p :proposition) {
            if (correct_order.contains(p)){
                score++;
            }
        }
        return score;
    }

    public int getQuestionScore(Question q, String proposition) {
        if (q.getAnswer() == proposition) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getQcmScore(Qcm qcm, Collection<String> proposition) {
        int score=0;
        Collection<String> correct_answers = qcm.getCorrect_options();
        for (String p : proposition) {
            if (correct_answers.contains(p)) {
                score++;
            }
        }
        return score;
    }

    public int getCourseMaxScore(int cid) {
        Course c = em.find(Course.class,cid);
        int max_score = 0;
        max_score += c.getQuestions().size();
        for (Qcm qcm : c.getQcms()) {
            max_score += qcm.getCorrect_options().size();
        }
        for (FillBlanks fb : c.getFillblanks()) {
            max_score += fb.getCorrect_options().size();
        }
        return max_score;
    }

}
