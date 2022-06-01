<%@ page language="java" import="java.util.Collection" import ="src.FillBlanks" import ="src.Qcm" import="src.Question" import="src.Course" contentType="text/html; charset=UTF-8"
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
    <link rel="stylesheet" href="doQuizz.css">
    
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
        <% int i = 0; %>
        <% Collection<Question> lquestion = (Collection<Question>) request.getAttribute("lquestion"); %>
        <% if (! lquestion.isEmpty()) {%>
        <% for (Question q : lquestion) {%>
        	<% i = i+1; %>
           <div class="qtext"> Question <%= i %> : </div><br>
           <div class="qtext"> <%= q.getQuestion_text() %></div><br>
           <div class="qanswer"> <%= q.getAnswer() %></div><br><br>
        <% System.out.println("ok");} %>
       <% } %>
       
       <% Collection<Qcm> lqcm = (Collection<Qcm>) request.getAttribute("lqcm"); %>
        <% if (!lqcm.isEmpty()) {%>
        <% for (Qcm qcm : lqcm) {%>
        	<% i = i+1; %>
           <div class="qtext"> Question <%= i %> : </div><br>
           <div class="qtext"> <%= qcm.getQuestion() %></div><br>
           <div class="qanswer"> <%= qcm.getCoption() %></div><br>
           <div class="wanswer"> <%= qcm.getFwoption() %></div><br>
           <div class="wanswer"> <%= qcm.getSwoption() %></div><br><br>
        <% System.out.println("ok");} %>
       <% } %>
       
       <% Collection<FillBlanks> lfb = (Collection<FillBlanks>) request.getAttribute("lfb"); %>
        <% if (!lfb.isEmpty()) {%>
        <% for (FillBlanks l : lfb) {%>
        	<% i = i+1; %>
           <div class="qtext"> Question <%= i %> : </div><br>
           <div class="qtext"> <%= l.getQuestion_text() %></div><br>
           <div class="qanswer"> <%= l.getFoption() %></div>
           <div class="qanswer"> <%= l.getSoption() %></div>
           <div class="qanswer"> <%= l.getToption() %></div>
           <div class="qanswer"> <%= l.getFooption() %></div>
        <% System.out.println("ok");} %>
       <% } %>
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
