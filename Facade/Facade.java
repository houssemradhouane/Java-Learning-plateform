package src;


import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;

@Singleton
public class Facade {

    @PersistenceContext
    private EntityManager em;

    public void addStudent(String n, String lastn, String pwd, String uname){
        Student s = new Student();
        s.setFirst_name(n);
        s.setLast_name(lastn);
        s.setPassword(pwd);
        s.setUsername(uname);
        em.persist(s);
    }

    public void addTeacher(String n, String lastn, String pwd, String uname){
        Teacher t = new Teacher();
        t.setFirst_name(n);
        t.setLast_name(lastn);
        t.setPassword(pwd);
        t.setUsername(uname);
        em.persist(t);
    }

    public void linkTeacherStudent(int sid, int tid) {
        Teacher t = em.find(Teacher.class,tid);
        Student s = em.find(Student.class,sid);
        s.setTeacher(t);
        t.add_student(s);
    }

    public Collection<Student> listStudents(int tid) {
        Teacher t = em.find(Teacher.class,tid);
        return t.getStudents();
    }

    public Collection<Student> listAllStudents() {
        TypedQuery<Student> req = em.createQuery("Select s from Student s", Student.class);
        return req.getResultList();
    }
    
    public Teacher findTeacher(String uname, String password) {
    	TypedQuery<Teacher> req = em.createQuery("Select t from Teacher t where t.username='" + uname +"'"
                +" and t.password='"+password +"'", Teacher.class);
    	return req.getSingleResult();
    	
    }

    public Collection<Teacher> listAllTeachers() {
        TypedQuery<Teacher> req = em.createQuery("Select t from Teacher t", Teacher.class);
        return req.getResultList();
    }

    public boolean checkTeacherLogin(String email, String pwd) {
        TypedQuery<Teacher> req = em.createQuery("Select t from Teacher t where t.username='" + email +"'"
                +" and t.password='"+pwd +"'", Teacher.class);
        return !req.getResultList().isEmpty();
    }

    public boolean checkStudentLogin(String email, String pwd) {
        TypedQuery<Student> req = em.createQuery("Select s from Student s where s.username='" + email+"'"
                +" and s.password='"+pwd +"'", Student.class);
        return !req.getResultList().isEmpty();
    }

    public void addCourse(String name, String content,Teacher teacher, String coursefile){
        Course course = new Course();
        course.setCourse_name(name);
        course.setCourse_content(content);
        course.setDone(false);
        course.setAuthor(teacher);
        course.setCourse_link(coursefile);
        em.persist(course);
    }
    
    public int findCourse(String cname) {
    	TypedQuery<Course> req = em.createQuery("Select c from Course c where c.course_name='" + cname +"'", Course.class);
        return req.getSingleResult().getCourse_id();
    }
    public Course findCoursebyName(String cname) {
    	TypedQuery<Course> req = em.createQuery("Select c from Course c where c.course_name='" + cname +"'", Course.class);
        return req.getSingleResult();
    }

    public void linkTeacherCourse(int cid, int tid) {
        Teacher t = em.find(Teacher.class,tid);
        Course c = em.find(Course.class,cid);
        c.setAuthor(t);
        t.add_course(c);
    }

    public Collection<Course> listCourses(int tid) {
        Teacher t = em.find(Teacher.class,tid);
        return t.getCourses();
    }

    public Collection<Course> listAllCourses() {
        TypedQuery<Course> req = em.createQuery("Select c from Course c", Course.class);
        return req.getResultList();
    }

    public void addQCM(String q, String correcto, String fwrongo, String swrongo, int cid){
        Qcm qcm = new Qcm();
        qcm.setQuestion(q);
        qcm.setCoption(correcto);
        qcm.setFwoption(fwrongo);
        qcm.setSwoption(swrongo);
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

    public void addFillBlanks(String q, String fo,String so,String to,String foo, int cid){
        FillBlanks fb = new FillBlanks();
        fb.setQuestion_text(q);
        fb.setFoption(fo);
        fb.setSoption(so);
        fb.setToption(to);
        fb.setFooption(foo);
        em.persist(fb);
        Course c = em.find(Course.class,cid);
        fb.setCourse(c);
        c.addFillBlanks(fb);
    }
    
    public void addOption(String value) {
    	Option op = new Option();
    	op.setValue(value);
    	em.persist(op);
    }

    public int getFbScore(FillBlanks fb, Collection<String> proposition) {
        Collection<String> correct_order = new ArrayList<String>();
        correct_order.add(fb.getFoption());
        correct_order.add(fb.getSoption());
        correct_order.add(fb.getToption());
        correct_order.add(fb.getFooption());
        int score = 0;
        for (String p :proposition) {
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

    public int getQcmScore(Qcm qcm, String proposition) {
        int score=0;
            if (qcm.getCoption().equals(proposition)) {
                score++;
            }
        return score;
    }

    public int getCourseMaxScore(int cid) {
        Course c = em.find(Course.class,cid);
        int max_score = 0;
        max_score += c.getQuestions().size();
        for (Qcm qcm : c.getQcms()) {
            max_score += 1;
        }
        for (FillBlanks fb : c.getFillblanks()) {
            max_score += 4;
        }
        return max_score;
    }

}
