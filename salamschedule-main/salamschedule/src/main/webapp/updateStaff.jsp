<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Update Staff</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
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
		
		li a:hover:not(.active) {
			color: black;
		}
		
		.active {
		   color: black;
		}
		
		
		@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
		
		*{
		  margin: 0;
		  padding: 0;
		  box-sizing: border-box;
		  font-family: 'Poppins',sans-serif
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
		  font-size: 45px;
		  font-weight: 600;
		}
		.center .sub_title{
		  color: #fff;
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
		
		
		.button-section button[type="button"]{
		    background: #A2B38B;
		    padding: 8px 30px;
		    border-radius: 2px;
			cursor:pointer;
		    -webkit-border-radius: 2px;
		    -moz-border-radius: 2px;
		    color: #fff;
		    text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.12);
		    font: normal 30px 'Bitter', serif;
		    -moz-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
		    -webkit-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
		    box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
		    border: 1px solid #A2B38B;
		    font-size: 15px;
				
	
	</style>
	
</head>
<body>

	
		<nav>
		<div class="menu">
	      <div class="logo">
	        <a href="#">MasjidSalam</a>
	      </div>
	      <ul>
	      
			<li><a href="ListStaffController">Back</a></li>
		  </ul>
		</div>
	</nav>
	
	
	<br><br>
	<div class="container col-md-5">
	
	<br><br><br>
		<div class="card">
			<div class="card-body">
			<form method="post" action="UpdateStaffController">
					<caption>
						<h2> Update Staff </h2>
					</caption>
					
					<fieldset class="form-group">
						<label>Staff Name</label> 
						<input type="text" class="form-control" id="name" name="name" required="required" placeholder="Ahmad Hakim*" value="${s.name}"/>
					</fieldset>
					
					<fieldset class="form-group">
						<label>Staff Address</label> 
						<input type="text" class="form-control" id="address" name="address" required="required" value="${s.address}"/>
					</fieldset>
	
					<fieldset class="form-group">
						<label>Staff Phone Number</label> 
						<input type="text" class="form-control" name="phone" id="phone" placeholder="0172547654*" value="${s.phone}"/>
					</fieldset>
	
					<fieldset class="form-group">
						<label>Staff Email</label> 
						<input type="text" value="${s.email}" class="form-control" id="email" name="email" placeholder="ahmadh@gmail.com*"/>
					</fieldset>
	
					<fieldset class="form-group">
						<label>Staff Role</label> 
						<select class="form-control" name="role" >
							<option value="<c:out value="${s.role}"">${s.role}<c:out value="${s.role}"/></option>
							<option value="Imam">Imam</option>
							<option value="Bilal">Bilal</option>
						</select>
					</fieldset>
					
					<input type="hidden" name="staffid1" value="${s.staffid1}"/>
					<input type="hidden" name="pass" value="${s.pass}"/>
					<input type="hidden" name="id" value="${s.id}"/>
					
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-success">Reset</button>
			</form>
			</div>
		</div><br>
	</div>
</body>
</html>