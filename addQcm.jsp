<%@ page language="java" import="java.util.Collection" import="src.Course" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!----======== CSS ======== -->
    <link rel="stylesheet" href="teacher.css">
    <link rel="stylesheet" href="addQuizz.css">
    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    
    <!--<title>Dashboard Sidebar Menu</title>--> 
</head>
<body>
    <nav class="sidebar close">
        <header>
            <div class="image-text">
                <span class="image">
                    <!--<img src="logo.png" alt="">-->
                </span>

                <div class="text logo-text">
                    <span class="name">JAVA7</span>
                    <span class="n7">@n7</span>
                </div>
            </div>

            <i class='bx bx-chevron-right toggle'></i>
        </header>

        <div class="menu-bar">
            <div class="menu">


                <ul class="menu-links">
                    <li class="nav-link">
                        <a href="Dashboard.html">
                            <span class="text nav-text">Dashboard</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <span class="text nav-text">Students</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="teacherCourses.html">
                            <span class="text nav-text">Courses</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="teacherQuizzes.html">
                            <span class="text nav-text">Quizzes</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="contact.html">
                            <span class="text nav-text">Help</span>
                        </a>
                    </li>

                </ul>
            </div>

            <div class="bottom-content">
                <li class="">
                    <a href="index.html">
                        <i class='bx bx-log-out icon' ></i>
                        <span class="text nav-text">Logout</span>
                    </a>
                </li>

                
            </div>
        </div>

    </nav>

    <div class="home">
        <div class="text">Dashboard Sidebar</div>
        			 <div class="container">
						  <form action="Servlet" method="get">
						  	<div class="row">
						      <div class="col-25">
						        <label for="country">Course</label>
						      </div>
						      <%Collection<Course> lc = (Collection<Course>) request.getAttribute("lc");%>
						        		
						      <div class="col-75">
						        <select id="course" name="course">
						         <% for (Course c : lc) {%>
						          <option value="<%= c.getCourse_name() %>"><%= c.getCourse_name() %></option>
						          <%} %>
						        </select>
						      </div>
						    </div>
						    <div class="row">
						      <div class="col-25">
						        <label for="fname">Question Text</label>
						      </div>
						      <div class="col-75">
						        <input type="text" id="qtext" name="qtext" placeholder="Your Question Text...">
						      </div>
						    </div>
						    <div class="row">
						      <div class="col-25">
						        <label for="lname">Correct Option</label>
						      </div>
						      <div class="col-75">
						        <input type="text" id="coption" name="coption" placeholder="Correct Option..">
						      </div>
						      <div class="col-25">
						        <label for="lname">Two Wrong Options</label>
						      </div>
						      <div class="col-75">
						        <input type="text" id="woption1" name="woption1" placeholder="Wrong Option..">
						      </div>
						      <div class="col-75">
						        <input type="text" id="woption2" name="woption2" placeholder="Wrong Option..">
						      </div>
						    </div><br>
						    <div class="row">
						      <input type="submit" name="op" value="QCU Done">
						    </div>
						  </form>
					</div> 
    </div>

    <script>
        const body = document.querySelector('body'),
      sidebar = body.querySelector('nav'),
      toggle = body.querySelector(".toggle"),
      modeSwitch = body.querySelector(".toggle-switch");


toggle.addEventListener("click" , () =>{
    sidebar.classList.toggle("close");
});
    </script>

</body>
</html>