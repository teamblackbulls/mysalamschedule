<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!------<title> Website Layout | CodingLab</title>------>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
	
	<title>Staff Home Page</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
		<style type="text/css">
		ul {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		  
		}
		
		li {
		  float: left;
		}
		
		li a {
		  color: white;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		}
	
		
		@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
		
		*{
		  margin: 0;
		  padding: 0;
		  box-sizing: border-box;
		  font-family: 'Poppins',sans-serif;
		}
		::selection{
		  color: #000;
		  background: #fff;
		}
		nav{
		  position: fixed;
		  background: #A2B38B;
		  width: 100%;
		  padding: 10px 0;
		  z-index: 12;
		}
		nav .menu{
		  max-width: 1250px;
		  margin: auto;
		  display: flex;
		  align-items: center;
		  justify-content: space-between;
		  padding: 0 20px;
		}
		.menu .logo a{
		  text-decoration: none;
		  color: #FAFDD6;
		  font-size: 35px;
		  font-weight: 600;
		}
		.menu ul{
		  display: inline-flex;
		}
		.menu ul li{
		  list-style: none;
		  margin-left: 7px;
		}
		.menu ul li:first-child{
		  margin-left: 0px;
		}
		.menu ul li a{
		  text-decoration: none;
		  color: #FAFDD6;
		  font-size: 18px;
		  font-weight: 500;
		  padding: 8px 15px;
		  border-radius: 5px;
		  transition: all 0.3s ease;
		}
		.menu ul li a:hover{
		  background: #FAFDD6;
		  color: #A2B38B;
		}
		.img{
		  background-image: url('istockphoto.jpg');
		  width: 100%;
		  height:100vh;
		  background-size: cover;
		  background-position: center;
		  position: relative;
		}
		.img::before{
		  content: '';
		  position: absolute;
		  height: 100%;
		  width: 100%;
		  background: rgba(0, 0, 0, 0.4);
		}
		.center{
		  position: absolute;
		  top: 52%;
		  left: 50%;
		  transform: translate(-50%, -50%);
		  width: 100%;
		  padding: 0 20px;
		  text-align: center;
		}
		.center .title{
		  color: #A2B38B;
		  font-size: 40px;
		  font-weight: 600;
		}
		
		.center .title2{
		  color: #A2B38B;
		  font-size: 40px;
		  font-weight: 600;
		}
		
		.center .sub_title{
		  color: #black;
		  font-size: 30epx;
		  font-weight: 600;
		}
		.center .btns{
		  margin-top: 20px;
		}
		.center .btns button{
		  height: 55px;
		  width: 170px;
		  border-radius: 5px;
		  border: none;
		  margin: 0 10px;
		  border: 2px solid white;
		  font-size: 20px;
		  font-weight: 500;
		  padding: 0 10px;
		  cursor: pointer;
		  outline: none;
		  transition: all 0.3s ease;
		}
		.center .btns button:first-child{
		  color: #fff;
		  background: none;
		}
		.btns button:first-child:hover{
		  background: white;
		  color: black;
		}
		.center .btns button:last-child{
		  background: white;
		  color: black;
		}	
	
	</style>
	
</head>
<body>
	
	<nav>
	    <div class="menu">
	      <div class="logo">
	        <a href="#">MasjidSalam</a>
	      </div>
	      <ul>

			<li><a href="#">Staff</a></li>
			<li><a href="index.html">Logout</a></li>
		  </ul>
	    </div>
	 </nav>
	
	
	<br><br><br><br>
	
	<%@page import="staff.db.ConnectionManager" %>
	<%@page import="java.sql.*" %>
	<%
	try {
	String staffid1 = request.getParameter("staffid1");
	Connection con = ConnectionManager.getConnection();	
	Statement st = con.createStatement();
	String sql = "SELECT * FROM staff WHERE staff.staffid1='" + staffid1 + "'";
	ResultSet rs = st.executeQuery(sql);
	if(rs.next()) { 
	
	%>
	<br><br>
	<div class="center">
		<div class="title">Welcome, <%=rs.getString(3)%>!</div>

	
	<br>

		<fieldset>
		<div class="sub_title"><b>My Personal Details:</b></div>
		Staff ID:  <%=rs.getString(2) %><br>
		Name: <%=rs.getString(3) %><br>
		Address: <%=rs.getString(4) %> <br>
		Phone Number: <%=rs.getString(5) %><br>
		Role:  <%=rs.getString(7) %><br><br>
		</fieldset>
		
		<div class="sub_title"><b>My Account Details:</b></div>
		Email: <%=rs.getString(6) %><br>
		Password: <%=rs.getString(8) %> <br><br>
	

	<%
	}
	else {
		response.sendRedirect("index.html");
	} 
	}catch (Exception e) {}%>
	
	<br>
	<form method="post" action="ListStaffScheduleController">
		<div class="login-box" class="center">
		<div class="title2">Display Schedule</div>
		<div class="sub_title"><b>Enter Your Staff ID:</b></div>
				<input type="text" id="staffid1" name="staffid1" required="required" placeholder="S00129">		
				<input type="submit" name="submit" value="submit">
		</div>
	</form>
	</div>
</body>
</html>
	

