package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @EJB
    Facade f;
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		System.out.println("op = " + op);
		switch(op) {
			case "add":
				String person_t = request.getParameter("accountType");
				System.out.println("person_t = " + person_t);
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String email = request.getParameter("email");
				String pwd = request.getParameter("password");
				if (person_t.equals("student")) {
					f.addStudent(fname, lname, pwd, email);
					//response.sendRedirect("student.html");
					request.getRequestDispatcher("student.html").forward(request, response);
				} else if (person_t.equals("teacher")){
					f.addTeacher(fname, lname, pwd, email);
					//response.sendRedirect("teacher.html");
					request.getRequestDispatcher("index.html").forward(request, response);
					
				}
				
				break;
			case "login":
				String person_login_t = request.getParameter("accountType");
				String mail = request.getParameter("email");
				String password = request.getParameter("password");
				if (person_login_t.equals("student")) {
					if (f.checkStudentLogin(mail, password)) {
						//response.sendRedirect("student.html");
						request.getRequestDispatcher("student.html").forward(request, response);
					}else {
						request.getRequestDispatcher("notRegistered.html").forward(request, response);
					}
					
				} else if (person_login_t.equals("teacher")){
					if (f.checkTeacherLogin(mail, password)) {
						//response.sendRedirect("teacher.html");
						request.getRequestDispatcher("teacher.html").forward(request, response);
					}
					else {
						request.getRequestDispatcher("notRegistered.html").forward(request, response);
					}
				}
				break;
			case "Create":
				request.getRequestDispatcher("quizzCreation.html").forward(request, response);
				break;
			case "Check":
				Collection<Course> sqlc = f.listAllCourses();
				request.setAttribute("lc", sqlc);
				request.getRequestDispatcher("seeQuizzes.jsp").forward(request, response);
				break;
			case "Create QCU":
				Collection<Course> lcq = f.listAllCourses();
				request.setAttribute("lc", lcq);
				request.getRequestDispatcher("addQcm.jsp").forward(request, response);
				break;
			case "Create Question":
				Collection<Course> lcqu = f.listAllCourses();
				request.setAttribute("lc", lcqu);
				request.getRequestDispatcher("addQuestion.jsp").forward(request, response);
				break;
			case "Create FB":
				Collection<Course> lcf = f.listAllCourses();
				request.setAttribute("lc", lcf);
				request.getRequestDispatcher("addFB.jsp").forward(request, response);
				break;
			case "New Course":
				request.getRequestDispatcher("addCourse.html").forward(request, response);
				break;
			case "Submit Course":
				String usnm = request.getParameter("username");
				String passwd = request.getParameter("password");
				if (f.checkTeacherLogin(usnm, passwd)) {
					System.out.println("ok");
					String coursename = request.getParameter("cName");
					String coursecontent = request.getParameter("cDescription");
					String coursefile = request.getParameter("cFile");
					Teacher teacher = f.findTeacher(usnm, passwd);
					f.addCourse(coursename, coursecontent,teacher,coursefile);
					request.getRequestDispatcher("teacherCourses.html").forward(request, response);
				}
				break;
			case "See Courses":
				Collection<Course> sclc = f.listAllCourses();
				request.setAttribute("lc", sclc);
				request.getRequestDispatcher("seeCourses.jsp").forward(request, response);
				break;
			case "Question Done":
				String qtext = request.getParameter("qtext");
				String coption = request.getParameter("coption");
				int cid = f.findCourse(request.getParameter("course"));
				f.addQestion(qtext, coption, cid);
				request.getRequestDispatcher("quizzCreation.html").forward(request, response);
				break;
			case "QCU Done":
				String qcmtext = request.getParameter("qtext");
				String qcmcoption = request.getParameter("coption");
				String qcmfwoption = request.getParameter("woption1");
				String qcmswoption = request.getParameter("woption2");
				int qcmcid = f.findCourse(request.getParameter("course"));
				f.addQCM(qcmtext, qcmcoption, qcmfwoption,qcmswoption, qcmcid);
				request.getRequestDispatcher("quizzCreation.html").forward(request, response);
				break;
			case "FB Done":
				String fbtext = request.getParameter("qtext");
				String fbfoption = request.getParameter("option1");
				String fbsoption = request.getParameter("option2");
				String fbtoption = request.getParameter("option3");
				String fbfooption = request.getParameter("option4");
				int fbcid = f.findCourse(request.getParameter("course"));
				f.addFillBlanks(fbtext, fbfoption, fbsoption, fbtoption, fbfooption, fbcid);
				request.getRequestDispatcher("quizzCreation.html").forward(request, response);
				break;
			case "Do the Quizz":
				String course_name = (String) request.getParameter("cname");
				System.out.println(course_name);
				Course quizzcourse = f.findCoursebyName(course_name);
				Collection<Question> lquestion = quizzcourse.getQuestions();
				Collection<Qcm> lqcm = quizzcourse.getQcms();
				Collection<FillBlanks> lfb = quizzcourse.getFillblanks();
				request.setAttribute("cname", course_name);
				request.setAttribute("lquestion", lquestion);
				request.setAttribute("lqcm", lqcm);
				request.setAttribute("lfb", lfb);
				request.getRequestDispatcher("doQuizz.jsp").forward(request, response);
				break;
		}
    }
}