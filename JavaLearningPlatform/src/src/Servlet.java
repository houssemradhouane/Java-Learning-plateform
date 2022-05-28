package src;

import java.io.IOException;
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
					request.getRequestDispatcher("teacher.html").forward(request, response);
				} else if (person_t.equals("teacher")){
					f.addTeacher(fname, lname, pwd, email);
					//response.sendRedirect("teacher.html");
					request.getRequestDispatcher("teacher.html").forward(request, response);
					
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
		}
    }
}