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
    <link rel="stylesheet" href="seeCourses.css">
    
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
                            <span class="text nav-text"></form>Dashboard</span>
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
        <div class="listcontainer">	
		<ul class="menu1">
		        <li class="active"><a href="#">Available Courses</a></li>
		        <br>
		        <%Collection<Course> lc = (Collection<Course>) request.getAttribute("lc");%>
		        <% for (Course c : lc) {%>
		        <li><a href="#"><%= c.getCourse_name() %></a>
		          <ul>
		            <li><a href="#"><%= c.getCourse_content() %></a></li>
		            <li><a href=<%=c.getCourse_link() %> >Read More</a></li>
		          </ul>
		        </li>
		        <br>
		        <%} %>
		      </ul>
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
